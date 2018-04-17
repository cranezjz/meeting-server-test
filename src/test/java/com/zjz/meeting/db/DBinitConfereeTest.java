package com.zjz.meeting.db;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zjz.meeting.dao.ConfereeDao;
import com.zjz.meeting.dao.MeetBaseInfoDao;
import com.zjz.meeting.dao.OrganizationDao;
import com.zjz.meeting.entity.Conferee;
import com.zjz.meeting.entity.MeetBaseInfo;
import com.zjz.meeting.entity.Organization;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DBinitConfereeTest {
	@Autowired
	private MeetBaseInfoDao meetBaseInfoDao;
	@Autowired
	private ConfereeDao confereeDao;
	@Autowired
	private OrganizationDao organizationDao;
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void insertMeetBaseInfo() throws Exception {
		List<MeetBaseInfo> meetBaseInfoList = meetBaseInfoDao.findAll();
		List<Organization> organs = organizationDao.findAll();
		int organ_num = organs.size();
		for (MeetBaseInfo meetBaseInfo : meetBaseInfoList) {
			String meet_id = meetBaseInfo.getId();
			for (int i = 0; i < 58; i++) {
				Conferee conferee = new Conferee();
				conferee.id="201"+i;
				conferee.meet_id = meet_id;
				conferee.name="姓名"+i;
				conferee.mobile="1891331"+(new Random(8999).nextInt()+1000);
				confereeDao.save(conferee);
			}
		}
	}
}
