package com.wtu.acquisition.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACQ_EXTEND_CONFIG")
public class AcqExtendsConfig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "FAIL_EMAIL")
	private String failEmail;
	@Column(name = "SUCCESS_EMAIL")
	private String successEmail;
	@Column
	private String enable;
	@Column
	private Timestamp updateStartTime;
	@Column
	private Timestamp updateEndTime;
	@Column
	private String updateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFailEmail() {
		return failEmail;
	}

	public void setFailEmail(String failEmail) {
		this.failEmail = failEmail;
	}

	public String getSuccessEmail() {
		return successEmail;
	}

	public void setSuccessEmail(String successEmail) {
		this.successEmail = successEmail;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public Timestamp getUpdateStartTime() {
		return updateStartTime;
	}

	public void setUpdateStartTime(Timestamp updateStartTime) {
		this.updateStartTime = updateStartTime;
	}

	public Timestamp getUpdateEndTime() {
		return updateEndTime;
	}

	public void setUpdateEndTime(Timestamp updateEndTime) {
		this.updateEndTime = updateEndTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}



}
