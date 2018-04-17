/**
 * 
 */
package com.zjz.meeting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.zjz.meeting.entity.User;


/**
 * <p>Title: MeetBaseInfoDao.java</p>  
 * <p>Description: </p>  
 * @author zhaojz
 * @date 2018年4月13日
 */
public interface UserDao extends JpaRepository<User, Integer> ,JpaSpecificationExecutor<User>{

}