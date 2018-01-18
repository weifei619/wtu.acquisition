package com.wtu.acquisition.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "QRTZ_TRIGGERS")
@IdClass(QrtTriggerPK.class)
public class QrtzTrigger implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	String SCHD_NAME;
	@Id
	String TRIGGER_NAME;
	@Id
	String TRUGGER_GROUP;
	private String JOB_NAME;
	private String NEXT_FIRE_TIME;
	private String PREV_FIRE_TIME;
	private String TRIGGER_STATE;
	private String DESCRIPTION;
	private String CRONEXP;
	private String startUpdateTime;
	private String endUpdateTime;
	private String prevFireTimestr;
	private String nextFireTimestr;

	public String getSCHD_NAME() {
		return SCHD_NAME;
	}

	public void setSCHD_NAME(String sCHD_NAME) {
		SCHD_NAME = sCHD_NAME;
	}

	public String getTRIGGER_NAME() {
		return TRIGGER_NAME;
	}

	public void setTRIGGER_NAME(String tRIGGER_NAME) {
		TRIGGER_NAME = tRIGGER_NAME;
	}

	public String getTRUGGER_GROUP() {
		return TRUGGER_GROUP;
	}

	public void setTRUGGER_GROUP(String tRUGGER_GROUP) {
		TRUGGER_GROUP = tRUGGER_GROUP;
	}

	public String getJOB_NAME() {
		return JOB_NAME;
	}

	public void setJOB_NAME(String jOB_NAME) {
		JOB_NAME = jOB_NAME;
	}

	public String getNEXT_FIRE_TIME() {
		return NEXT_FIRE_TIME;
	}

	public void setNEXT_FIRE_TIME(String nEXT_FIRE_TIME) {
		NEXT_FIRE_TIME = nEXT_FIRE_TIME;
	}

	public String getPREV_FIRE_TIME() {
		return PREV_FIRE_TIME;
	}

	public void setPREV_FIRE_TIME(String pREV_FIRE_TIME) {
		PREV_FIRE_TIME = pREV_FIRE_TIME;
	}

	public String getTRIGGER_STATE() {
		return TRIGGER_STATE;
	}

	public void setTRIGGER_STATE(String tRIGGER_STATE) {
		TRIGGER_STATE = tRIGGER_STATE;
	}

	public String getDESCRIPTION() {
		return DESCRIPTION;
	}

	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}

	public String getCRONEXP() {
		return CRONEXP;
	}

	public void setCRONEXP(String cRONEXP) {
		CRONEXP = cRONEXP;
	}

	public String getStartUpdateTime() {
		return startUpdateTime;
	}

	public void setStartUpdateTime(String startUpdateTime) {
		this.startUpdateTime = startUpdateTime;
	}

	public String getEndUpdateTime() {
		return endUpdateTime;
	}

	public void setEndUpdateTime(String endUpdateTime) {
		this.endUpdateTime = endUpdateTime;
	}

	public String getPrevFireTimestr() {
		return prevFireTimestr;
	}

	public void setPrevFireTimestr(String prevFireTimestr) {
		this.prevFireTimestr = prevFireTimestr;
	}

	public String getNextFireTimestr() {
		return nextFireTimestr;
	}

	public void setNextFireTimestr(String nextFireTimestr) {
		this.nextFireTimestr = nextFireTimestr;
	}
}
