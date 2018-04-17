package com.zjz.meeting.db;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zjz.meeting.dao.MeetBaseInfoDao;
import com.zjz.meeting.dao.OrganizationDao;
import com.zjz.meeting.entity.MeetBaseInfo;
import com.zjz.meeting.entity.Organization;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DBinitMeetingBaseInfoTest {
	@Autowired
	private MeetBaseInfoDao meetBaseInfoDao;
	@Autowired
	private OrganizationDao organizationDao;
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void insertMeetBaseInfo() throws Exception {
		meetBaseInfoDao.deleteAll();
		List<Organization> list = organizationDao.findByName("南京银行");
		String host_org = list.get(0).id;
		for (int i = 0; i < 22; i++) {
			MeetBaseInfo entity = new MeetBaseInfo();
			entity.id="100"+i;
			entity.name="会议名称"+i;
			entity.host_org=host_org;
			entity.begin_date="20180416";
			entity.end_date="20180418";
			int a = new Random().nextInt(3);
			if(a==0) {
				entity.stt="00";
			}else if(a==1) {
				entity.stt="10";
			}else{
				entity.stt="20";
			}
			entity.issue_date="20180410";
			entity.address="南京市玄武区中山路268号";
			entity.last_apply_date="20180416";
			if(new Random().nextInt(5)==0) {
				entity.allow_apply_group=entity.host_org;
			}else {
				entity.allow_apply_group=null;
			}
			if(new Random().nextInt(2)==0) {
				entity.apply_confirm_flag="0";
			}else {
				entity.apply_confirm_flag="1";
			}
			if(new Random().nextInt(2)==0) {
				entity.feast_confirm_flag="0";
			}else {
				entity.feast_confirm_flag="1";
			}
			entity.insert_date="20180410";
			entity.modify_date="20180410";
			entity.operator_id="001";
			meetBaseInfoDao.save(entity);
		}
	}
}
