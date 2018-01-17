package com.wtu.acquisition.entity;

public class QrtTriggerPK {
	private String SCHD_NAME;
	private String TRIGGER_NAME;
	private String TRUGGER_GROUP;
 /**
  * 表QRTI——CORON_TRIGGER的主键类，可用其他的相同的复合主键表
  */
	public int hashCode() {
		final int prime=31;
		int result=1;
		result=prime*result+(SCHD_NAME==null?0:SCHD_NAME.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(getClass()!=obj.getClass())
			return false;
		QrtTriggerPK other = (QrtTriggerPK) obj;
		if(SCHD_NAME==null) {
			if(other.SCHD_NAME!=null)
				return false;
		}
		else if(!SCHD_NAME.equals(other.SCHD_NAME)) {
			return false;
		}
		return true;
			
	}
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
}
