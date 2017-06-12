package com.huaao.ejwplatform.service.qrcode;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;  
import com.google.zxing.EncodeHintType;  
import com.google.zxing.MultiFormatWriter;  
import com.google.zxing.WriterException;  
import com.google.zxing.client.j2se.MatrixToImageWriter;  
import com.google.zxing.common.BitMatrix;  
import com.huaao.ejwplatform.common.util.FileUtil;
import com.huaao.ejwplatform.dao.JwCriminalRecord;
import com.huaao.ejwplatform.mapper.JwCriminalRecordMapper;  

@Service
public class QrCodeService {

	@Value("${uploadPath}")
	private String uploadPath;
	
	@Value("${qrcodePath}")
	private String qrcodePath;
	
	@Autowired
	private JwCriminalRecordMapper jwCriminalRecordMapper;
	
	//for UI design 
	private static final int QRCODE_WIDTH = 420;
	private static final int QRCODE_HEIGHT = 420;
	
	private static final String PATH_PREFIX = "qrcode/";
	private static final String FILE_TYPE = "png";
	
	public String createQrcode(String recordId){
		JwCriminalRecord record = jwCriminalRecordMapper.selectByPrimaryKey(recordId);
		//gen qrcode link url from context
		
		
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();  
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        
        //create new folder
        String today = DateUtil.formatDate(new Date(), "yyyy-MM-dd");
        File savePath = new File(uploadPath+PATH_PREFIX);
        if(!savePath.exists()){
        	savePath.mkdir();
        }
        savePath = new File(uploadPath+PATH_PREFIX+today);
        if(!savePath.exists()){
        	savePath.mkdir();
        }
        //gen file name by idcard
        String fileName = record.getIdcardNo()+"_"+(new Date()).getTime()+"."+FILE_TYPE;
        
        createQrcode(qrcodePath+recordId, QRCODE_WIDTH, QRCODE_HEIGHT, hints, PATH_PREFIX+today, fileName);
        
        JwCriminalRecord data = new JwCriminalRecord();
        data.setId(recordId);
        String qrcode = PATH_PREFIX+today+"/"+fileName;
        data.setQrcode(qrcode);
        jwCriminalRecordMapper.updateByPrimaryKeySelective(record);
        
        return qrcode;
	}
	
	public void createQrcode(String content, int width, int height, Map<EncodeHintType, Object> hints, String filePath, String fileName){
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content,  
			        BarcodeFormat.QR_CODE, width, height, hints);
			Path path = FileSystems.getDefault().getPath(uploadPath+filePath, fileName);  
			String format = FileUtil.getExtensionName(fileName);
			MatrixToImageWriter.writeToPath(bitMatrix, format, path);
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
