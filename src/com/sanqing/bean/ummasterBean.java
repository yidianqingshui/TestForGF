package com.sanqing.bean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.Collection;
import org.apache.struts.util.LabelValueBean;

public class ummasterBean {
	
	public ummasterBean(){
	
	}
	private Collection beanCollection;
	
	public Collection getBeanCollection() {

		HibernateDao.Ummaster M_Vendtype = new HibernateDao.Ummaster();
		HibernateDao.UmmasterDAO D_Vendtype = new HibernateDao.UmmasterDAO();

		List MyDao = D_Vendtype.findAll();
		ArrayList arrData = new ArrayList();
		Iterator Temp = MyDao.iterator();
		while (Temp.hasNext()) {
			M_Vendtype = (HibernateDao.Ummaster) Temp.next();
			arrData.add(new LabelValueBean(M_Vendtype.getUmDesc(),
					M_Vendtype.getUmId()));
		}
		this.beanCollection = arrData;
		return beanCollection;
	}
}
