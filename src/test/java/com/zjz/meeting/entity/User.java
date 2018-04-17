package com.zjz.meeting.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_base")
public class User {
	/**
	 * 编号
	 */
	@Id
	public java.lang.String id;
	/**
	 * 姓名
	 */
	@Column
	public java.lang.String name;
	/**
	 * 性别
	 */
	@Column
	public java.lang.String gender;
	/**
	 * 职称
	 */
	@Column
	public java.lang.String title;
	/**
	 * 职级（对应系统中等级值）
	 */
	@Column
	public double rank;
	/**
	 * 归属机构
	 */
	@Column
	public java.lang.String organization;
	/**
	 * 上次同步时间
	 */
	@Column
	public java.lang.String syn_time;
}
