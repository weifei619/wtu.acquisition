package com.wtu.acquisition.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Entity
@Table(name = "Qrtz_Cron_Trigger")
@IdClass(QrtTriggerPK.class)
public class QrtzCronTrigger implements Serializable {

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

	private String CRON_EXPRESSION;

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

	public String getCRON_EXPRESSION() {
		return CRON_EXPRESSION;
	}

	public void setCRON_EXPRESSION(String cRON_EXPRESSION) {
		CRON_EXPRESSION = cRON_EXPRESSION;
	}
}
