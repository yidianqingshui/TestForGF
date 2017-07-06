package com.sanqing.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

public class itemBean {
public itemBean(){
		
	}
private Collection beanCollection;
public Collection getBeanCollection() {

	HibernateDao.Itemgeneral Itemgeneral = new HibernateDao.Itemgeneral();
	HibernateDao.ItemgeneralDAO ItemgeneralDAO = new HibernateDao.ItemgeneralDAO();

	List MyDao = ItemgeneralDAO.findAll();
	ArrayList arrData = new ArrayList();
	Iterator Temp = MyDao.iterator();
	while (Temp.hasNext()) {
		Itemgeneral = (HibernateDao.Itemgeneral) Temp.next();
		arrData.add(new LabelValueBean(Itemgeneral.getItemId(),Itemgeneral.getItemId()));
	}
	this.beanCollection = arrData;
	return beanCollection;
}
}
