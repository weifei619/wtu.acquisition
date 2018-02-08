package com.wtu.acquisition.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class BaseHibernateTempleDao {
	protected HibernateTemplate HibernateTempleDao;

	@Autowired
	public void setHibernateTempleDao(HibernateTemplate hibernateTempleDao) {
		HibernateTempleDao = hibernateTempleDao;
	}
}
