package com.sanqing.bean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.Collection;
import org.apache.struts.util.LabelValueBean;

import HibernateDao.Shipvin;

public class employeeBean {
	public employeeBean(){
		
	}
	private Collection beanCollection;
	
	public Collection getBeanCollection() {

		HibernateDao.Employee M_Vendtype = new HibernateDao.Employee();
		HibernateDao.EmployeeDAO D_Vendtype = new HibernateDao.EmployeeDAO();

		List MyDao = D_Vendtype.findAll();
		ArrayList arrData = new ArrayList();
		Iterator Temp = MyDao.iterator();
		while (Temp.hasNext()) {
			M_Vendtype = (HibernateDao.Employee) Temp.next();
			arrData.add(new LabelValueBean(M_Vendtype.getEmpDesc(),
					M_Vendtype.getEmpId()));
		}
		this.beanCollection = arrData;
		return beanCollection;
	}
}
