package com.sanqing.bll;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import HibernateDao.*;

public class BItemGeneral {
	
	private HibernateDao.Itemgeneral M_ITEM = new HibernateDao.Itemgeneral();
	private HibernateDao.ItemgeneralDAO D_ITEM = new HibernateDao.ItemgeneralDAO();
	
	
	public BItemGeneral(){}
	
	/**
	 * 这个是显示在页面的数据，选择要显示什么字段
	 * @return
	 */
	public String ItemsConvertToHTMLTable(){
		Session session = D_ITEM.getSession();
		session.clear();
		StringBuilder HTML = new StringBuilder("");
		boolean CreateOnclick = true;
		boolean CreateOnmouseOver = false; 
		List MyDao = D_ITEM.findAll();
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
			this.M_ITEM = (Itemgeneral)Temp.next();
			if (this.M_ITEM.getNumber()<this.M_ITEM.getSafestroage()) {
			HTML.append(" bgcolor='#FFF68F'");
		   }
			if (this.M_ITEM.getNumber()>this.M_ITEM.getMaxstroage()) {
				HTML.append(" bgcolor='#FF4040'");
			   }
			HTML.append(">");
			try{
									
				System.out.println("表示"+this.M_ITEM.getNumber());
				System.out.println(this.M_ITEM.getSafestroage());
				HTML.append("<td>");
				HTML.append(this.M_ITEM.getItemId());
				HTML.append("</td>");
				
				HTML.append("<td>");
				HTML.append(this.M_ITEM.getItemDesc());
				HTML.append("</td>");
				
				HTML.append("<td>");
				HTML.append(this.M_ITEM.getClasscode().getProdDesc());
				HTML.append("</td>");
							
				HTML.append("<td>");
				HTML.append(this.M_ITEM.getWarehouseBywareid().getWareDesc());
				HTML.append("</td>");
				
				HTML.append("<td>");
				HTML.append(this.M_ITEM.getLocationBylocationid().getLocaDesc());
				HTML.append("</td>");
				
				HTML.append("<td>");
				HTML.append(this.M_ITEM.getNumber());
				HTML.append("</td>");
				
				HTML.append("<td>");
				HTML.append(this.M_ITEM.getVendermasterByvendid().getVendDesc());
				HTML.append("</td>");
				
				
			}catch(Exception eee){
				eee.printStackTrace();
			}
			
			HTML.append("</tr>");
		}
		String Temp1 = HTML.toString();
		return HTML.toString();
	}
	
	
	/**
	 * 
	 * @param VendID
	 * @return
	 */
	//相对应页面json的设置，各个框显示的内容定位
	public String Item_ConvertModelToJson(String VendID){
		 Session session = D_ITEM.getSession();
		session.clear();
		Itemgeneral MyType = D_ITEM.findById(VendID);
		com.sanqing.common.json MyJson = new com.sanqing.common.json();
		MyJson.Reset();
		MyJson.set_success(true);
		//MyJson.AddItem("color", MyType.getColor());
		System.out.println("这是数据库状态："+MyType.getStatus());
		MyJson.AddItem("prod_code", MyType.getClasscode().getProdId());
		System.out.println(MyType.getItemDesc());
		MyJson.AddItem("item_desc", MyType.getItemDesc());
		MyJson.AddItem("item_id", MyType.getItemId());
		MyJson.AddItem("status", MyType.getStatus());
		MyJson.AddItem("po_emp_id", MyType.getClasscode().getProdId());
		MyJson.AddItem("sale_emp_id", MyType.getEmployeeBySaleEmpId().getEmpId());
		MyJson.AddItem("po_emp_id", MyType.getEmployeeByPoEmpId().getEmpId());
		MyJson.AddItem("sale_pic", String.valueOf(MyType.getSalePic()));
		MyJson.AddItem("um_id", MyType.getUmmaster().getUmId());
		MyJson.AddItem("wareId",MyType.getWarehouseBywareid().getWareId() );
		MyJson.AddItem("locaId",MyType.getLocationBylocationid().getLocaId() );
		MyJson.AddItem("vendId", MyType.getVendermasterByvendid().getVendId());
		MyJson.AddItem("number", String.valueOf(MyType.getNumber()));
		MyJson.AddItem("safestroage", String.valueOf(MyType.getSafestroage()));
		MyJson.AddItem("maxstroage", String.valueOf(MyType.getMaxstroage()));
		MyJson.ItemOk();
		return MyJson.toString();
	}
	
	
	/**
	 * 
	 * @param MyType
	 * @return
	 */
	public boolean Item_Add(Itemgeneral MyType)
	{
		Session session = D_ITEM.getSession();
		try{
			Transaction MyAction = session.beginTransaction();
			D_ITEM.save(MyType);
			MyAction.commit();
		}
		catch(Exception eee){
			return false;
		}
		return true;
	}
	
	/**
	 * �޸�����
	 * @return
	 */
	public boolean Item_Edit(Itemgeneral MyType){
		Session session = D_ITEM.getSession();
		try{			
			Transaction MyAction = session.beginTransaction();
			Itemgeneral Temp = D_ITEM.findById(MyType.getItemId());
			Temp.setClasscode(MyType.getClasscode());
			//Temp.setColor(MyType.getColor());
			Temp.setEceipts(MyType.getEceipts());
			Temp.setEmployeeByPoEmpId(MyType.getEmployeeByPoEmpId());
			Temp.setEmployeeBySaleEmpId(MyType.getEmployeeBySaleEmpId());
			Temp.setItemDesc(MyType.getItemDesc());
			Temp.setSalePic(MyType.getSalePic());
			Temp.setStatus(MyType.getStatus());
			Temp.setUmmaster(MyType.getUmmaster());
			Temp.setWarehouseBywareid(MyType.getWarehouseBywareid());
			Temp.setLocationBylocationid(MyType.getLocationBylocationid());
			Temp.setVendermasterByvendid(MyType.getVendermasterByvendid());
			Temp.setNumber(MyType.getNumber());
			Temp.setSafestroage(MyType.getSafestroage());
			Temp.setMaxstroage(MyType.getMaxstroage());
			D_ITEM.save(Temp);
			MyAction.commit();
		}
		catch(Exception eee){
			return false;
		}finally{
			session.close();
		}
		return true;
		
	}
	
	/**
	 * �޸�����
	 * @return
	 */
	public boolean Item_Delete(String ID){
		try{
			Transaction MyAction = D_ITEM.getSession().beginTransaction();
			Itemgeneral MyType = D_ITEM.findById(ID);
			D_ITEM.delete(MyType);
			MyAction.commit();
		}
		catch(Exception eee){
			return false;
		}
		return true;
	}
	
}
