package com.wtu.acquisition.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Entity
@Table(name = "Qrtz_Cron_Trigger")
@IdClass(QrtTriggerPK.class)
public class QrtzCronTrigger implements Serializable{

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
	
}
