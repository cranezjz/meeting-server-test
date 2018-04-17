package com.zjz.meeting.db;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zjz.meeting.dao.OrganizationDao;
import com.zjz.meeting.entity.Organization;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DBinitOrganizationTest {
	@Autowired
	private OrganizationDao organizationDao;
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void insertOrganization() throws Exception {
		String[] names= {"长春农商行","齐鲁银行","建湖农商行","射阳农商行","辽阳银行",
				"丹东银行","日照银行","海安农商行","肥西农商","张家口市商业银行",
				"德清农商行","鞍山银行","宁夏银行","福建海峡银行","石嘴山银行",
				"吴江农商行","南京银行"};
		double[] assets= {100000000.00,200000000.00,300000000.00,400000000.00,500000000.00,
						600000000.00,620000000.00,660000000.00,670000000.00,690000000.00,
						700000000.00,770000000.00,789000000.00,800000000.00,880000000.00,
						990000000.00,1200000000.00};
		organizationDao.deleteAll();
		for (int i = 0; i < names.length; i++) {
			Organization organization = new Organization();
			organization.id = "1001"+i;
			organization.name = names[i];
			organization.asset_size =assets[i];
			int a = new Random(3).nextInt();
			if(a==0) {
				organization.org_type ="10";
			}else if(a==1){
				organization.org_type ="20";
			}else {
				organization.org_type ="30";
			}
			organization.syn_time ="20180401";
			organizationDao.save(organization);
		}
	}
}
