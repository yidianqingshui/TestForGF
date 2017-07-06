package com.sanqing.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

public class vendbean {
public vendbean(){
		
	}
private Collection beanCollection;
public Collection getBeanCollection() {

	HibernateDao.Vendermaster Vendermaster = new HibernateDao.Vendermaster();
	HibernateDao.VendermasterDAO VendermasterDAO = new HibernateDao.VendermasterDAO();

	List MyDao = VendermasterDAO.findAll();
	ArrayList arrData = new ArrayList();
	Iterator Temp = MyDao.iterator();
	while (Temp.hasNext()) {
		Vendermaster = (HibernateDao.Vendermaster) Temp.next();
		arrData.add(new LabelValueBean(Vendermaster.getVendDesc(),
				Vendermaster.getVendId()));
	}
	this.beanCollection = arrData;
	return beanCollection;
}
}
