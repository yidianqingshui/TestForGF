package com.sanqing.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

public class WareHousebean {
public WareHousebean(){
		
	}
private Collection beanCollection;
public Collection getBeanCollection() {

	HibernateDao.Warehouse Warehouse = new HibernateDao.Warehouse();
	HibernateDao.WarehouseDAO WarehouseDAO = new HibernateDao.WarehouseDAO();

	List MyDao = WarehouseDAO.findAll();
	ArrayList arrData = new ArrayList();
	Iterator Temp = MyDao.iterator();
	while (Temp.hasNext()) {
		Warehouse = (HibernateDao.Warehouse) Temp.next();
		arrData.add(new LabelValueBean(Warehouse.getWareDesc(),
				Warehouse.getWareId()));
	}
	this.beanCollection = arrData;
	return beanCollection;
}
}
