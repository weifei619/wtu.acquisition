package com.wtu.acquisition.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;

public class AcqConfigLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private int id;
	@Column
	private int recordId;
	@Column
	private Timestamp updateStartTime;
	@Column
	private Timestamp updateEndTime;
	@Column
	private String detail;
	@Column
	private String ip;
	@Column
	private int configId;
	@Column
	private Timestamp taskStartTime;
	@Column
	private Timestamp taskEndTime;
	@Column
	private Integer pageStart;
	@Column
	private Integer pageEnd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getConfigId() {
		return configId;
	}

	public void setConfigId(int configId) {
		this.configId = configId;
	}

	public Timestamp getTaskStartTime() {
		return taskStartTime;
	}

	public void setTaskStartTime(Timestamp taskStartTime) {
		this.taskStartTime = taskStartTime;
	}

	public Timestamp getTaskEndTime() {
		return taskEndTime;
	}

	public void setTaskEndTime(Timestamp taskEndTime) {
		this.taskEndTime = taskEndTime;
	}

	public Integer getPageStart() {
		return pageStart;
	}

	public void setPageStart(Integer pageStart) {
		this.pageStart = pageStart;
	}

	public Integer getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(Integer pageEnd) {
		this.pageEnd = pageEnd;
	}
}
