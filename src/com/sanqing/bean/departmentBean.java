package com.sanqing.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

public class departmentBean {
public departmentBean(){
		
	}
private Collection beanCollection;
public Collection getBeanCollection() {

	HibernateDao.Department Department = new HibernateDao.Department();
	HibernateDao.DepartmentDAO DepartmentDAO = new HibernateDao.DepartmentDAO();

	List MyDao = DepartmentDAO.findAll();
	ArrayList arrData = new ArrayList();
	Iterator Temp = MyDao.iterator();
	while (Temp.hasNext()) {
		Department = (HibernateDao.Department) Temp.next();
		arrData.add(new LabelValueBean(Department.getDepartmentName(),
				Department.getDepartmengtId()));
	}
	this.beanCollection = arrData;
	return beanCollection;
}

}
