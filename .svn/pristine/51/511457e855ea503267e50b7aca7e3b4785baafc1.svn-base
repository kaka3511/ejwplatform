package com.huaao.ejwplatform.api.control;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.bean.MeetingRoom;
import com.huaao.ejwplatform.api.dto.bean.RoomInfoXy;
import com.huaao.ejwplatform.api.dto.meetingRoom.DtoInvitP2pXiaoyuResponse;
import com.huaao.ejwplatform.api.dto.meetingRoom.DtoInviteRequest;
import com.huaao.ejwplatform.api.dto.meetingRoom.DtoInvitep2pRequest;
import com.huaao.ejwplatform.api.dto.meetingRoom.DtoInvitep2pXiaoyuRequest;
import com.huaao.ejwplatform.api.dto.meetingRoom.DtoRefuseP2pRequest;
import com.huaao.ejwplatform.api.dto.meetingRoom.DtoUpdateRoomRequest;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponse;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseList;
import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.dao.JwMeetingRoom;
import com.huaao.ejwplatform.dao.SysDeptWithBLOBs;
import com.huaao.ejwplatform.service.MeetingRoomService;
import com.huaao.ejwplatform.service.model.MeetingRoomInfo;
import com.huaao.ejwplatform.service.system.DeptService;

@ApiDescription("视频会议")
@Controller
@RequestMapping("/api/meetingroom")
public class MeetingRoomController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MeetingRoomService meetingRoomService;
	
	@Autowired
	private DeptService deptService;
	
	@ApiDescription("会议室列表;负责人：shilei")
	@RequestMapping("list")
	@ResponseBody
	public DtoPublicResponseList<MeetingRoom> list(DtoPublicRequest req)  throws Exception {
		DtoPublicResponseList<MeetingRoom> resp = new DtoPublicResponseList<MeetingRoom>();
		String uid = req.getUid();
		log.info("uid : {}", uid);
		SysDeptWithBLOBs dept = deptService.getPolicyDeptByUserId(uid);
		if(dept == null){
			resp.setCode(Constants.API_CODE_FAIL);//500
			resp.setMsg("未查到视频会议房间信息");
			return resp;
		}
		try{
			List<JwMeetingRoom> resList = meetingRoomService.getMeetingRoomListByDepId(dept.getId());
			List<MeetingRoom> repList = new ArrayList<MeetingRoom>();
			for(JwMeetingRoom jmr : resList){
				MeetingRoom mr = new MeetingRoom();
				BeanUtils.copyProperties(jmr, mr);
				repList.add(mr);
			}
			resp.setData(repList);
			resp.setCode(Constants.API_CODE_SUCCESS);//0
		}catch(Exception e){
			log.error("get meetingRoom list fail", e);
			resp.setCode(Constants.API_CODE_FAIL);//500
			resp.setMsg("未查到视频会议房间信息");
		}

		return resp;
	}
	
	@ApiDescription("手机沙盘互联;负责人：lihao")
    @RequestMapping(value = {"invite_p2p_xiaoyu"}, method = {GET, POST})
    @ResponseBody
    public DtoInvitP2pXiaoyuResponse actionInviteP2p_xiaoyu(DtoInvitep2pXiaoyuRequest dtoRequest) throws Exception {
    	DtoInvitP2pXiaoyuResponse dtoResponse = new DtoInvitP2pXiaoyuResponse();
    	try {
    		String meetingnumber = meetingRoomService.inviteP2p_xiaoyu(dtoRequest.getUid(), dtoRequest.getToid());
    		dtoResponse.setMeetingnumber(meetingnumber);
            return dtoResponse;
		} catch (Exception e) {
			dtoResponse.setFail(e.getMessage());
			return dtoResponse;
		}
    }
    
    
    @ApiDescription("会议拒绝;负责人：jinsu")
    @RequestMapping(value = {"refuse_p2p"}, method = {GET, POST})
    @ResponseBody
    public DtoPublicResponse actionRefuseP2p(DtoRefuseP2pRequest dtoRequest) throws Exception {
    	try {
			meetingRoomService.refuseP2p(dtoRequest.getUid(), dtoRequest.getRoomid(), dtoRequest.getToid());
		} catch (Exception e) {
			return DtoPublicResponse.fail(e.getMessage());
		}
    	return DtoPublicResponse.init();
    }
    
    @ApiDescription("发起会议邀请;负责人：lihao")
    @RequestMapping(value = {"invite"}, method = {GET, POST})
    @ResponseBody
    public DtoPublicResponse actionInvite( DtoInviteRequest dtoRequest) throws Exception {

    	try {
    		 final String[] uidstrs = StringUtils.split(dtoRequest.getUidStr(), ",");
    	        final List<String> uidlist = new ArrayList<>();
    	        for (String uidstr : uidstrs) {
    	            uidlist.add(uidstr);
    	        }
    	        if (uidlist.isEmpty()) {
    	            return DtoPublicResponse.fail("邀请参与会议人员至少一个");  
    	        }
    	        meetingRoomService.sendInvitation(dtoRequest.getUid(), dtoRequest.getInviter() ,dtoRequest.getTopic() ,dtoRequest.getTime() ,dtoRequest.getRoomid() ,dtoRequest.getRoomidstr() ,dtoRequest.getRoomname() ,dtoRequest.getPassword() , uidlist,dtoRequest.getMessage() );
    	        return DtoPublicResponse.init();
		} catch (Exception e) {
			return DtoPublicResponse.fail(e.getMessage());
		}
    }
    
	@ApiDescription("*个人对个人视频互联;负责人：lihao")
    @RequestMapping(value = {"invite_p2p"})
    @ResponseBody
    public DtoPublicResponse actionInviteP2p(DtoInvitep2pRequest dtoRequest )  {
    	try {
    		meetingRoomService.inviteP2p(dtoRequest.getUid(), dtoRequest.getRoomid(), dtoRequest.getToid());
            return DtoPublicResponse.init();
		} catch (Exception e) {
			return DtoPublicResponse.fail(e.getMessage());
		}
    	
    }

	@ApiDescription("*小鱼房间列表;负责人：lihao")
    @RequestMapping(value = {"room_list_xy"}, method = {GET, POST})
    @ResponseBody
    public DtoPublicResponseList<RoomInfoXy> actionRoomListXY(DtoPublicRequest dtoRequest ) throws Exception {
    	DtoPublicResponseList dtoResponse = new DtoPublicResponseList<>();
    	try {
    		List<MeetingRoomInfo> list = meetingRoomService.getMeetingRoomList_xy(dtoRequest.getUid());
    		List<RoomInfoXy> datas = FuncTool.copyPropertiesList(list, RoomInfoXy.class);
    		dtoResponse.setData(datas);
    		return dtoResponse;
		} catch (Exception e) {
			dtoResponse.setFail(e.getMessage());
			return dtoResponse;
		}
    }
    
	@ApiDescription("*更新会议室;负责人：lihao")
    @RequestMapping(value = {"update_room"}, method = {GET, POST})
    @ResponseBody
    public DtoPublicResponse actionUpdateRoom(DtoUpdateRoomRequest dtoRequest ) throws Exception {
    	try {
        	meetingRoomService.updateMeetingRoom(dtoRequest.getId(), dtoRequest.getName(), dtoRequest.getNotice(), dtoRequest.getRoomid(), dtoRequest.getPassword());
        	return DtoPublicResponse.init();
		} catch (Exception e) {
			return DtoPublicResponse.fail(e.getMessage());
		}
    }
	

}
