package com.huaao.ejwplatform.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gexin.rp.sdk.template.AbstractTemplate;
import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.dao.JwInvitationParticipantKey;
import com.huaao.ejwplatform.dao.JwMeetingInvitation;
import com.huaao.ejwplatform.dao.JwMeetingRoom;
import com.huaao.ejwplatform.dao.JwMeetingRoomExample;
import com.huaao.ejwplatform.dao.JwMeetingRoomXy;
import com.huaao.ejwplatform.dao.JwMeetingRoomXyExample;
import com.huaao.ejwplatform.dao.SysUser;
import com.huaao.ejwplatform.mapper.JwInvitationParticipantMapper;
import com.huaao.ejwplatform.mapper.JwMeetingInvitationMapper;
import com.huaao.ejwplatform.mapper.JwMeetingRoomMapper;
import com.huaao.ejwplatform.mapper.JwMeetingRoomXyMapper;
import com.huaao.ejwplatform.service.model.MeetingInvitationHelper;
import com.huaao.ejwplatform.service.model.MeetingInvitationInfo;
import com.huaao.ejwplatform.service.model.MeetingInvitationTransmission;
import com.huaao.ejwplatform.service.model.MeetingRoomHelper;
import com.huaao.ejwplatform.service.model.MeetingRoomInfo;
import com.huaao.ejwplatform.service.model.MeetingRoomType;
import com.huaao.ejwplatform.service.model.NewPushMessage;
import com.huaao.ejwplatform.service.model.PushMessage;
import com.huaao.ejwplatform.service.model.PushMessageType;
import com.huaao.ejwplatform.service.model.UserType;
import com.huaao.ejwplatform.service.model.XiaoYuMeeting;
import com.huaao.ejwplatform.service.mq.MqttService;

@Service
public class MeetingRoomService {

	@Autowired
	private JwMeetingRoomMapper jwMeetingRoomMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private PushService pushService;
	@Autowired
	private JwMeetingInvitationMapper meetingInvitationMapper;
	@Autowired
	private JwInvitationParticipantMapper invitationParticipantMapper;
	@Autowired
	private XiaoYuService xiaoYuService;
	@Autowired
	private JwMeetingRoomXyMapper meetingRoomXyMapper;
	@Autowired
	private MqttService mqttService;
	@Autowired
	private GetuiService getuiService;

	public List<JwMeetingRoom> getMeetingRoomList() {
		JwMeetingRoomExample exa = new JwMeetingRoomExample();
		return jwMeetingRoomMapper.selectByExample(exa);
	}
	
	public List<JwMeetingRoom> getMeetingRoomListByDepId(String deptId) {
		JwMeetingRoomExample exa = new JwMeetingRoomExample();
		exa.createCriteria().andDeptIdEqualTo(deptId);
		return jwMeetingRoomMapper.selectByExample(exa);
	}

	public void inviteP2p(String uid, String roomid, String toid) throws Exception {

		SysUser fromUser = userService.queryUser(uid);
		SysUser toUser = userService.queryUser(toid);

		MeetingInvitationInfo info = new MeetingInvitationInfo();
		info.roomidstr = roomid;
		info.inviter = fromUser.getUserName();
		info.inviterid = fromUser.getId();
		info.invitericon = fromUser.getImg();

		MeetingInvitationTransmission mt = new MeetingInvitationTransmission(info);

		String cid = toUser.getGtCode();

		if (cid == null || cid.isEmpty() || cid.trim().isEmpty()) {
			throw new Exception("对方不在线");
		}
		
		List<String> uids = new ArrayList<String>();
		uids.add(toUser.getId());
		
		pushService.createPushMessage(PushMessageType.P2pCall, info, uids);
	}

	public void sendInvitation(String uid, String inviter, String title, long time, String roomid, String roomidstr,
			String roomname, String password, List<String> uidlist, String message) {
		JwMeetingInvitation invitation = new JwMeetingInvitation();
		invitation.setId(FuncTool.createUUID());
		invitation.setTitle(title);
		invitation.setTime(time / 1000);
		invitation.setPassword(password);
		invitation.setMessage(message);
		invitation.setCreatetime(System.currentTimeMillis() / 1000);
		invitation.setRoomid(roomid);
		invitation.setRoomidstr(roomidstr);
		invitation.setInviterid(uid);
		invitation.setInvitername(inviter);
		invitation.setRoomname(roomname);

		meetingInvitationMapper.insertSelective(invitation);

		for (String participantId : uidlist) {
			JwInvitationParticipantKey invitationParticipant = new JwInvitationParticipantKey();
			invitationParticipant.setInvitationid(invitation.getId());
			invitationParticipant.setUid(participantId);
			invitationParticipantMapper.insert(invitationParticipant);
		}

		final List<String> cids = userService.getGetuiCidsByUids(uidlist);
		MeetingInvitationInfo mInfo = MeetingInvitationHelper.convert(invitation);

		pushService.createPushMessage(PushMessageType.MeetingInvitation, mInfo, uidlist);
	}
	
	public String inviteP2p_xiaoyu(String uid, String toid) throws Exception {
		long now = System.currentTimeMillis();
		XiaoYuMeeting xiaoYuMeeting = xiaoYuService.createMeeting("视频通话", now, now + 600 * 1000, 5);
		SysUser fromUser = userService.getUserById(uid);
		SysUser toUser = userService.getUserById(toid);

		MeetingInvitationInfo info = new MeetingInvitationInfo();
		info.roomidstr = xiaoYuMeeting.meetingNumber;
		info.inviter = fromUser.getUserName();
		info.inviterid = fromUser.getId();
		info.invitericon = fromUser.getImg();

		MeetingInvitationTransmission mt = new MeetingInvitationTransmission(info);

		String cid = toUser.getGtCode();

		if (cid == null || cid.isEmpty() || cid.trim().isEmpty()) {
			throw new Exception("对方不在线");
		}
		
		List<String> uids = new ArrayList<String>();
		uids.add(toUser.getId());
		
		pushService.createPushMessage(PushMessageType.P2pCall, info, uids);

		return xiaoYuMeeting.meetingNumber;
	}

	public List<MeetingRoomInfo> getMeetingRoomList_xy(String uid) {
		SysUser user = userService.getUserById(uid);

		JwMeetingRoomXyExample example = new JwMeetingRoomXyExample();
		JwMeetingRoomXyExample.Criteria criteria = example.createCriteria() ;

		// 民警返回所有会议室
		if (user.getType() != null && Integer.parseInt(user.getType()) != UserType.Police.value) {
			criteria.andTypeNotEqualTo(MeetingRoomType.Internal.value);
		}

		List<JwMeetingRoomXy> roomList = meetingRoomXyMapper.selectByExample(example);

		if (roomList.size() == 0) {
			// 如果不存在则创建房间
			for (MeetingRoomType type : MeetingRoomType.values()) {
				JwMeetingRoomXy room = createMeetingRoomXy(10001, type.value);
				if (user.getType()!=null && Integer.parseInt(user.getType()) != UserType.Police.value && type == MeetingRoomType.Internal)
					continue;
				roomList.add(room);
			}
		}

		List<MeetingRoomInfo> roomInfoList = new ArrayList<>();
		for (JwMeetingRoomXy room : roomList) {
			roomInfoList.add(MeetingRoomHelper.convert(room));
		}

		return roomInfoList;
	}
	
	public JwMeetingRoomXy createMeetingRoomXy(int communityid, Integer type) {
        JwMeetingRoomXy room = new JwMeetingRoomXy();
        long now = System.currentTimeMillis();
        room.setId(FuncTool.createUUID());
        room.setType(type);
        room.setCreatetime(now);
        room.setUpdatetime(now);
        room.setCommunityid(communityid);
        if (type == MeetingRoomType.Internal.value) {
            room.setName("内部会议室");
        } else if (type == MeetingRoomType.Mediate.value) {
            room.setName("调解室");
        } else if (type == MeetingRoomType.Interact.value) {
            room.setName("警民互动室");
        }

        XiaoYuMeeting xiaoYuMeeting = xiaoYuService.createMeeting(room.getName(), 1459321942000L, 1775545942000L, 10);

        room.setRoomid(xiaoYuMeeting.meetingNumber);
        room.setUrl(xiaoYuMeeting.shareUrl);

        meetingRoomXyMapper.insertSelective(room);
        return room;
    }
	
	public void updateMeetingRoom(String id, String name, String notice, String roomId, String password) {
        JwMeetingRoomXy room = new JwMeetingRoomXy();
        room.setId(id);
        room.setName(name);
        room.setNotice(notice);
        room.setRoomid(roomId);
        room.setPassword(password);

        meetingRoomXyMapper.updateByPrimaryKeySelective(room);
    }
	
	public void refuseP2p(String uid, String roomid, String toid) {
        SysUser fromUser = userService.getUserById(uid);
        SysUser toUser = userService.getUserById(toid);

        MeetingInvitationInfo info = new MeetingInvitationInfo();
        info.roomidstr = roomid;
        info.inviter = fromUser.getRealname();
        info.inviterid = fromUser.getId();
        info.invitericon = fromUser.getImg();

        MeetingInvitationTransmission mt = new MeetingInvitationTransmission(info);
        final AbstractTemplate template = getuiService.truansmissionTemplate(PushMessageType.P2pRefuse.create(mt));
        
        List<String> uids = new ArrayList<String>();
		uids.add(toid);
		
		pushService.createPushMessage(PushMessageType.P2pRefuse, info, uids);
		mqttService.pushToAll(toUser.getDeptId(), uids, template.getTransmissionContent());
    }
}
