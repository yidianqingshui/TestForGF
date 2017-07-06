/**
 * 
 */
package com.sanqing.bll;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Transaction;

/**
 * @author Administrator
 *
 */
public class BDepartment {
	private HibernateDao.Department M_L = new HibernateDao.Department();
	private HibernateDao.DepartmentDAO D_L = new HibernateDao.DepartmentDAO();
	
	public BDepartment(){
		
	}
	
	public String DepartmentConConvertToHTMLTable()
	{
		StringBuilder HTML = new StringBuilder("");
		boolean CreateOnclick = true;
		boolean CreateOnmouseOver = false; 
		List MyDao = D_L.findAll();
		Iterator Temp = MyDao.iterator();
		while(Temp.hasNext())
		{
			HTML.append("<tr");
			if(CreateOnclick){
				HTML.append(" onclick='clickTR(this)'");
			}
			if(CreateOnmouseOver){
				HTML.append(" onmouseover='overTR(this)'");
			}
			HTML.append(">");
			try{
				this.M_L = (HibernateDao.Department)Temp.next();
				
				HTML.append("<td>");
				HTML.append(this.M_L.getDepartmengtId());
				HTML.append("</td>");
				
				HTML.append("<td>");
				HTML.append(this.M_L.getDepartmentName());
				HTML.append("</td>");
				
			}catch(Exception eee){
				eee.printStackTrace();
			}
			
			HTML.append("</tr>");
		}
		String Temp1 = HTML.toString();
		return HTML.toString();
	}
	
	public boolean DepartmentAdd(com.sanqing.struts.form.DepartmentEditorForm LEF){
		try{
			Transaction MyAction = D_L.getSession().beginTransaction();
			M_L.setDepartmengtId(LEF.getDepartmengtId());
			M_L.setDepartmentName(LEF.getDepartmentName());
			D_L.save(M_L);
			MyAction.commit();
		}
		catch(Exception eee){
			return false;
		}
		return true;
	}
	
	public boolean DepartmentEdit(com.sanqing.struts.form.DepartmentEditorForm LEF){
		try{
			Transaction MyAction = D_L.getSession().beginTransaction();
			M_L = D_L.findById(LEF.getDepartmengtId());
			M_L.setDepartmengtId(LEF.getDepartmengtId());
			M_L.setDepartmentName(LEF.getDepartmentName());
			D_L.save(M_L);
			MyAction.commit();
		}
		catch(Exception eee){
			return false;
		}
		return true;
	}
	
	public boolean DepartmentDelete(String ID){
		try{
			Transaction MyAction = D_L.getSession().beginTransaction();
			M_L = D_L.findById(ID);
			D_L.delete(M_L);
			MyAction.commit();
		}
		catch(Exception eee){
			return false;
		}
		return true;
	}
}
