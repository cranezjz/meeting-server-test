package com.zjz.meeting.db;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zjz.meeting.dao.OrganizationDao;
import com.zjz.meeting.dao.UserDao;
import com.zjz.meeting.entity.Organization;
import com.zjz.meeting.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DBinitUserTest {
	@Autowired
	private OrganizationDao organizationDao;
	@Autowired
	private UserDao userDao;
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void insertOrganization() throws Exception {
		userDao.deleteAll();
		List<Organization> list = organizationDao.findAll();
		int index=1;
		for (Organization organization : list) {
			String organId = organization.id;
			for (int i = 0; i <10; i++) {
				index++;
				User user = new User();
				user.id = "1001"+index;
				user.name = "姓名"+index;
				user.gender="1";
				int a = new Random().nextInt(5);
				if(a==4){
					user.title="行长";
				}else if(a==3){
					user.title="总经理";
				}else if(a==2){
					user.title="副总经理";
				}else if(a==1){
					user.title="经理";
				}else {
					user.title="职员";
				}
				user.rank=a;
				if(i==0) {
					user.title="董事长";
					user.rank=5;
				}
				user.organization=organId;
				user.syn_time="20180401";
				userDao.save(user);
			}
		}
	}
}
