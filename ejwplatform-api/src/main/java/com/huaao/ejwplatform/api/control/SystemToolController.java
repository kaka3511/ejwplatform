package com.huaao.ejwplatform.api.control;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.huaao.ejwplatform.api.dto.bean.RequestLogFullInfo;
import com.huaao.ejwplatform.api.dto.bean.RequestLogInfo;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponse;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseObj;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponsePager;
import com.huaao.ejwplatform.api.dto.systemtool.DtoQueryAllApiResponse;
import com.huaao.ejwplatform.api.dto.systemtool.DtoQueryLogDetailRequest;
import com.huaao.ejwplatform.api.dto.systemtool.DtoQueryRequestLogRequest;
import com.huaao.ejwplatform.api.util.ApiTool;
import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.common.util.DateTool;
import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.common.web.CoordConvert;
import com.huaao.ejwplatform.dao.SysLogsRequest;
import com.huaao.ejwplatform.dao.SysLogsRequestWithBLOBs;
import com.huaao.ejwplatform.dao.SysUser;
import com.huaao.ejwplatform.service.RequestLogService;
import com.huaao.ejwplatform.service.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("api/systemtool")
public class SystemToolController {
	private static Set<String> filterApi = new HashSet<>();
	static {
		filterApi.add("/api/html/getContent.do");
		filterApi.add("/api/demo/*");
		filterApi.add("/api/systemtool/*");
	}
	Set<Class<?>> listApiClass = getClasses("com.huaao.ejwplatform.api.control");
	@Autowired
	private UserService userService;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private RequestLogService requestLogService;
	
	private static String AMAP_QUERY_ONLINE_USER_URL = "http://yuntuapi.amap.com/datamanage/data/list?tableid=58b6399aafdf520ea84159cf&key=9b5fc4b54aada032211000047d875f65&sortrule=_updatetime:0&limit=100&page=";

	@RequestMapping("queryOnlineUser")
	@ResponseBody
	public DtoPublicResponse queryOnlineUser(DtoPublicRequest dtoRequest) {
		try {
			List<SysUser> onlineUsers = new ArrayList<SysUser>();
			int count = 0;
			int page = 1;
			do{
				onlineUsers.clear();
				String res = restTemplate.getForObject(AMAP_QUERY_ONLINE_USER_URL+page, String.class);
				JSONObject jo = JSONObject.fromObject(res);
				JSONArray array = jo.getJSONArray("datas");
				for (int i = 0; i < array.size(); i++) {
					JSONObject userInfo = array.getJSONObject(i);
					Long updateTime = DateTool.dateStrToTimeStap(userInfo.getString("_updatetime")) ;
					Long nowTime = DateTool.nowTimeStap();
					//当前时间大于updateTime 5分钟，表示下线
					if(nowTime < updateTime + 1000*60*5){
						SysUser user = new SysUser();
						user.setId(userInfo.getString("userId"));
						user.setPosition(userInfo.getString("_location"));
						user.setBdPosition(CoordConvert.Amap2Baidu(userInfo.getString("_location")));
						onlineUsers.add(user);
					}
				}
				userService.updateOnlineUser(onlineUsers);
				page++;
				count += onlineUsers.size();
			}while (onlineUsers.size() == 100);
			
			return DtoPublicResponse.init("online "+count);
		} catch (Exception e) {
			return DtoPublicResponse.fail(e.getMessage());
		}
	}
	
	@RequestMapping("queryRequestLog")
	@ResponseBody
	public DtoPublicResponsePager<RequestLogInfo> queryRequestLog(DtoQueryRequestLogRequest dtoRequest) throws Exception {
		DtoPublicResponsePager<RequestLogInfo> dtoResponse = new DtoPublicResponsePager<>();
		SysLogsRequest log = FuncTool.copyPropertiesClass(dtoRequest, SysLogsRequest.class);
		Page p = ApiTool.convert(dtoRequest);
		List<SysLogsRequest> list = requestLogService.query( p,log,DateTool.parseDateTime(dtoRequest.getStartTime()), DateTool.parseDateTime(dtoRequest.getEndTime()));
		dtoResponse.setData(FuncTool.copyPropertiesList(list, RequestLogInfo.class));
		ApiTool.fillPagerData(p, dtoResponse);
		return dtoResponse;
	}
	 
	@RequestMapping("queryLogDetail")
	@ResponseBody
	public DtoPublicResponseObj<RequestLogFullInfo> queryLogDetail(DtoQueryLogDetailRequest dtoRequest) throws Exception {
		DtoPublicResponseObj<RequestLogFullInfo> dtoResponse = new DtoPublicResponseObj<>();
		SysLogsRequestWithBLOBs obj = requestLogService.queryFullInfo(dtoRequest.getReqId());
		dtoResponse.setData(FuncTool.copyPropertiesClass(obj, RequestLogFullInfo.class));
		return dtoResponse;
	}
	
	@RequestMapping("queryAllApi")
	@ResponseBody
	public DtoQueryAllApiResponse queryAllApi(DtoPublicRequest dtoRequest) throws Exception {
		DtoQueryAllApiResponse dtoResponse = new DtoQueryAllApiResponse();
		List<String> data = new ArrayList<>();
		
		TreeMap<String,Integer> pageCat = new TreeMap<>();
		for (Class clazzApi : listApiClass) {
			RequestMapping clazzRm = (RequestMapping) clazzApi.getAnnotation(RequestMapping.class);
			if (clazzRm == null) {
				continue;
			}
			String mapApi = clazzRm.value()[0];
			if (!mapApi.startsWith("/")) {
				mapApi = "/" + mapApi;
			}
			// 反射API
			Method[] methods = clazzApi.getMethods();
			for (Method itemMethod : methods) {
				RequestMapping rm = itemMethod.getAnnotation(RequestMapping.class);
				if (rm != null) {
					String tmp = rm.value()[0];
					if (!tmp.startsWith("/")) {
						tmp = "/" + rm.value()[0];
					}
					if (!tmp.endsWith(".do")) {
						tmp = tmp + ".do";
					}
					String apiUrl = mapApi + tmp;
					boolean filterFlag = false;
					for(String filter : filterApi) {
						if(filter.contains("*") && apiUrl.startsWith(filter.substring(0, filter.length()-1))){
							filterFlag = true;
						}
						if(apiUrl.equals(filter)){
							filterFlag = true;
						}
					}
					if(filterFlag){
						continue;
					}
					
					data.add(apiUrl);
				}
			}
		}
		dtoResponse.setData(data);
		return dtoResponse;
	}
	
	private static Set<Class<?>> getClasses(String pack) {  
		  
        // 第一个class类的集合  
        Set<Class<?>> classes = new LinkedHashSet<Class<?>>();  
        // 是否循环迭代  
        boolean recursive = true;  
        // 获取包的名字 并进行替换  
        String packageName = pack;  
        String packageDirName = packageName.replace('.', '/');  
        // 定义一个枚举的集合 并进行循环来处理这个目录下的things  
        Enumeration<URL> dirs;  
        try {  
            dirs = Thread.currentThread().getContextClassLoader().getResources(  
                    packageDirName);  
            // 循环迭代下去  
            while (dirs.hasMoreElements()) {  
                // 获取下一个元素  
                URL url = dirs.nextElement();  
                // 得到协议的名称  
                String protocol = url.getProtocol();  
                // 如果是以文件的形式保存在服务器上  
                if ("file".equals(protocol)) {  
                    //System.err.println("file类型的扫描");  
                    // 获取包的物理路径  
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");  
                    // 以文件的方式扫描整个包下的文件 并添加到集合中  
                    findAndAddClassesInPackageByFile(packageName, filePath,  
                            recursive, classes);  
                } else if ("jar".equals(protocol)) {  
                    // 如果是jar包文件  
                    // 定义一个JarFile  
                    JarFile jar;  
                    try {  
                        // 获取jar  
                        jar = ((JarURLConnection) url.openConnection())  
                                .getJarFile();  
                        // 从此jar包 得到一个枚举类  
                        Enumeration<JarEntry> entries = jar.entries();  
                        // 同样的进行循环迭代  
                        while (entries.hasMoreElements()) {  
                            // 获取jar里的一个实体 可以是目录 和一些jar包里的其他文件 如META-INF等文件  
                            JarEntry entry = entries.nextElement();  
                            String name = entry.getName();  
                            // 如果是以/开头的  
                            if (name.charAt(0) == '/') {  
                                // 获取后面的字符串  
                                name = name.substring(1);  
                            }  
                            // 如果前半部分和定义的包名相同  
                            if (name.startsWith(packageDirName)) {  
                                int idx = name.lastIndexOf('/');  
                                // 如果以"/"结尾 是一个包  
                                if (idx != -1) {  
                                    // 获取包名 把"/"替换成"."  
                                    packageName = name.substring(0, idx)  
                                            .replace('/', '.');  
                                }  
                                // 如果可以迭代下去 并且是一个包  
                                if ((idx != -1) || recursive) {  
                                    // 如果是一个.class文件 而且不是目录  
                                    if (name.endsWith(".class")  
                                            && !entry.isDirectory()) {  
                                        // 去掉后面的".class" 获取真正的类名  
                                        String className = name.substring(  
                                                packageName.length() + 1, name  
                                                        .length() - 6);  
                                        try {  
                                            // 添加到classes  
                                            classes.add(Class  
                                                    .forName(packageName + '.'  
                                                            + className));  
                                        } catch (ClassNotFoundException e) {  
                                            // log  
                                            // .error("添加用户自定义视图类错误 找不到此类的.class文件");  
                                            e.printStackTrace();  
                                        }  
                                    }  
                                }  
                            }  
                        }  
                    } catch (IOException e) {  
                        // log.error("在扫描用户定义视图时从jar包获取文件出错");  
                        e.printStackTrace();  
                    }  
                }  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
  
        return classes;  
    }  
	
	private static void findAndAddClassesInPackageByFile(String packageName,  
            String packagePath, final boolean recursive, Set<Class<?>> classes) {  
        // 获取此包的目录 建立一个File  
        File dir = new File(packagePath);  
        // 如果不存在或者 也不是目录就直接返回  
        if (!dir.exists() || !dir.isDirectory()) {  
            // log.warn("用户定义包名 " + packageName + " 下没有任何文件");  
            return;  
        }  
        // 如果存在 就获取包下的所有文件 包括目录  
        File[] dirfiles = dir.listFiles(new FileFilter() {  
            // 自定义过滤规则 如果可以循环(包含子目录) 或则是以.class结尾的文件(编译好的java类文件)  
            public boolean accept(File file) {  
                return (recursive && file.isDirectory())  
                        || (file.getName().endsWith(".class"));  
            }  
        });  
        // 循环所有文件  
        for (File file : dirfiles) {  
            // 如果是目录 则继续扫描  
            if (file.isDirectory()) {  
                findAndAddClassesInPackageByFile(packageName + "."  
                        + file.getName(), file.getAbsolutePath(), recursive,  
                        classes);  
            } else {  
                // 如果是java类文件 去掉后面的.class 只留下类名  
                String className = file.getName().substring(0,  
                        file.getName().length() - 6);  
                try {  
                    // 添加到集合中去  
                    //classes.add(Class.forName(packageName + '.' + className));  
                                         //经过回复同学的提醒，这里用forName有一些不好，会触发static方法，没有使用classLoader的load干净  
                                        classes.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + '.' + className));    
                                } catch (ClassNotFoundException e) {  
                    // log.error("添加用户自定义视图类错误 找不到此类的.class文件");  
                    e.printStackTrace();  
                }  
            }  
        }  
    }  
}
