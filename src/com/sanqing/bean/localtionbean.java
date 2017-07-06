package com.sanqing.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

public class localtionbean {
public localtionbean(){
		
	}
private Collection beanCollection;
public Collection getBeanCollection() {

	HibernateDao.Location Location = new HibernateDao.Location();
	HibernateDao.LocationDAO LocationDAO = new HibernateDao.LocationDAO();

	List MyDao = LocationDAO.findAll();
	ArrayList arrData = new ArrayList();
	Iterator Temp = MyDao.iterator();
	while (Temp.hasNext()) {
		Location = (HibernateDao.Location) Temp.next();
		arrData.add(new LabelValueBean(Location.getLocaDesc(),
				Location.getLocaId()));
	}
	this.beanCollection = arrData;
	return beanCollection;
}

}
