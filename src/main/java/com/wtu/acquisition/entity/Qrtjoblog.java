package com.wtu.acquisition.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "acq_collection_records")
public class Qrtjoblog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column(name = "collection_name")
	private String collectionName;
	@Column
	private String updateStartTime;
	@Column
	private String updateEndTime;
	@Column
	private String taskstartTime;
	@Column
	private String taskendTime;
	@Column
	private Date nextUpdateEnd;
	@Column
	private String startIp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public String getUpdateStartTime() {
		return updateStartTime;
	}

	public void setUpdateStartTime(String updateStartTime) {
		this.updateStartTime = updateStartTime;
	}

	public String getUpdateEndTime() {
		return updateEndTime;
	}

	public void setUpdateEndTime(String updateEndTime) {
		this.updateEndTime = updateEndTime;
	}

	public String getTaskstartTime() {
		return taskstartTime;
	}

	public void setTaskstartTime(String taskstartTime) {
		this.taskstartTime = taskstartTime;
	}

	public String getTaskendTime() {
		return taskendTime;
	}

	public void setTaskendTime(String taskendTime) {
		this.taskendTime = taskendTime;
	}

	public Date getNextUpdateEnd() {
		return nextUpdateEnd;
	}

	public void setNextUpdateEnd(Date nextUpdateEnd) {
		this.nextUpdateEnd = nextUpdateEnd;
	}

	public String getStartIp() {
		return startIp;
	}

	public void setStartIp(String startIp) {
		this.startIp = startIp;
	}

}