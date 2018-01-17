package com.wtu.acquisition.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

import com.wtu.acquisition.enumtype.AcquisionConfigFromTypeEnum;

@Entity
@Table(name = "ACQ_CONFIG")
public class AcquisionConfig implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private AcquisionConfigFromTypeEnum resourceFrom;
	private String url;
	private String totalUrl;
	private String team;
	private String project;
	private Date updateStartTime;
	private UserRight userRight;
	private String pdu;
	private String label;
	private String isincrement;
	private String errorInfo;

	@Id
	@GeneratedValue(generator = "acquisitionConfigGenerator")
	@Column
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	@Enumerated(EnumType.STRING)
	public AcquisionConfigFromTypeEnum getResourceFrom() {
		return resourceFrom;
	}

	public void setResourceFrom(AcquisionConfigFromTypeEnum resourceFrom) {
		this.resourceFrom = resourceFrom;
	}

	@Column
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column
	public String getTotalUrl() {
		return totalUrl;
	}

	public void setTotalUrl(String totalUrl) {
		this.totalUrl = totalUrl;
	}

	@Column
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Column
	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	@Column
	public Date getUpdateStartTime() {
		return updateStartTime;
	}

	public void setUpdateStartTime(Date updateStartTime) {
		this.updateStartTime = updateStartTime;
	}

	@Column
	public UserRight getUserRight() {
		return userRight;
	}

	public void setUserRight(UserRight userRight) {
		this.userRight = userRight;
	}

	@Column
	public String getPdu() {
		return pdu;
	}

	public void setPdu(String pdu) {
		this.pdu = pdu;
	}

	@Column
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Column
	public String getIsincrement() {
		return isincrement;
	}

	public void setIsincrement(String isincrement) {
		this.isincrement = isincrement;
	}

	@Column
	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

}
