package com.wtu.acquisition.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class BaseHibernateTempleDao {
	protected HibernateTemplate HibernateTempleDao;

	public void setHibernateTempleDao(HibernateTemplate hibernateTempleDao) {
		HibernateTempleDao = hibernateTempleDao;
	}
}
