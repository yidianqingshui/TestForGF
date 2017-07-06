package com.sanqing.bean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.Collection;
import org.apache.struts.util.LabelValueBean;

import HibernateDao.Shipvin;

public class classCodeBean {
	public classCodeBean(){
		
	}
	
	private Collection beanCollection;
	
	public Collection getBeanCollection() {

		HibernateDao.Classcode M_Vendtype = new HibernateDao.Classcode();
		HibernateDao.ClasscodeDAO D_Vendtype = new HibernateDao.ClasscodeDAO();

		List MyDao = D_Vendtype.findAll();
		ArrayList arrData = new ArrayList();
		Iterator Temp = MyDao.iterator();
		while (Temp.hasNext()) {
			M_Vendtype = (HibernateDao.Classcode) Temp.next();
			arrData.add(new LabelValueBean(M_Vendtype.getProdDesc(),
					M_Vendtype.getProdId()));
		}
		this.beanCollection = arrData;
		return beanCollection;
	}
	
}
