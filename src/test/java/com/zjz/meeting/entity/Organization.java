package com.zjz.meeting.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organization")
public class Organization {
	/**
	 * 编号
	 */
	@Id
	public java.lang.String id;
	/**
	 * 机构名称
	 */
	@Column
	public java.lang.String name;
	/**
	 * 资产规模(单位亿)
	 */
	@Column
	public double asset_size;
	/**
	 * 机构类型:10-主席成员行; 20-成员行；30-非成员行
	 */
	@Column
	public java.lang.String org_type;
	/**
	 * 同步时间
	 */
	@Column
	public java.lang.String syn_time;
}
