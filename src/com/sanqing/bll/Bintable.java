package com.sanqing.bll;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.apache.commons.validator.Form;
import org.apache.struts.action.ActionForm;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sanqing.struts.form.IntableForm;

import HibernateDao.*;

public class Bintable {
	
	private HibernateDao.Intable M_ITEM = new HibernateDao.Intable();
	private HibernateDao.IntableDAO D_ITEM = new HibernateDao.IntableDAO();
	
	private SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd");
	public Bintable(){}
	
	public String ItemsaddToHTMLTable(ActionForm form){
		//从IntableForm获取物料的信息
		boolean CreateOnclick = true;
		IntableForm IntableForm = (IntableForm) form;
		StringBuilder HTML = new StringBuilder(""); 
		HTML.append("<tr>");
		
		HTML.append("<td>");
		HTML.append(IntableForm.getWarehouseWarrant());
		HTML.append("</td>");
		
		HTML.append("<td");
		HTML.append(" id='itid'");
		HTML.append(">");
		HTML.append(IntableForm.getItemId());
		HTML.append("</td>");
		
		HTML.append("<td>");
		HTML.append(IntableForm.getItemDesc());
		HTML.append("</td>");
		
	
		 
		HTML.append("<td>");
		HTML.append(IntableForm.getNumber());
		HTML.append("</td>");
		
		HTML.append("<td>");
		HTML.append(" <input");
		HTML.append("  type='button'"); 
		HTML.append("  value='删除'"); 
		HTML.append("  onClick='clearitem(this);'"); 
		HTML.append(" >");
		HTML.append("</td>");
		
		
		HTML.append("</tr>");
		return HTML.toString();
	}
	
	/**
	 * 这个是显示在页面的数据，选择要显示什么字段
	 * @return
	 */
	public String ItemsConvertToHTMLTable(){
		
		StringBuilder HTML = new StringBuilder("");
		boolean CreateOnclick = true;
		boolean CreateOnmouseOver = false; 
		Session session = D_ITEM.getSession();
		session.clear();
		List MyDao = D_ITEM.findAll();
		Iterator Temp = MyDao.iterator();
		while(Temp.hasNext())
		{
			session.clear();
			HTML.append("<tr");
			if(CreateOnclick){
				HTML.append(" onclick='clickTR(this)'");
			}
			if(CreateOnmouseOver){
				HTML.append(" onmouseover='overTR(this)'");
			}
			HTML.append(">");
			try{
				this.M_ITEM = (Intable)Temp.next();	
				session.clear();
				HTML.append("<td>");
				HTML.append(this.M_ITEM.getId().getWarehouseWarrant());
				HTML.append("</td>");
				
				HTML.append("<td>");
				HTML.append(this.M_ITEM.getId().getItemId());
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
				HTML.append(new SimpleDateFormat("yyyy-MM-dd").format(this.M_ITEM.getIndate()));
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
	public String Item_ConvertModelToJson(IntableId id){
		Session session = D_ITEM.getSession();
		session.clear();
		Intable MyType = D_ITEM.findById(id);
		com.sanqing.common.json MyJson = new com.sanqing.common.json();
		MyJson.Reset();
		MyJson.set_success(true);
		MyJson.AddItem("prodCode", MyType.getClasscode().getProdId());
		MyJson.AddItem("itemDesc", MyType.getItemDesc());
		MyJson.AddItem("itemId", String.valueOf(MyType.getId().getItemId()));
		MyJson.AddItem("poEmpId", MyType.getEmployeeByPoEmpId().getEmpId());
		MyJson.AddItem("salePic", String.valueOf(MyType.getSalePic()));
		MyJson.AddItem("wareId",MyType.getWarehouseBywareid().getWareId() );
		MyJson.AddItem("locaId",MyType.getLocationBylocationid().getLocaId() );
		MyJson.AddItem("warehouseWarrant",String.valueOf(MyType.getId().getWarehouseWarrant()));
		MyJson.AddItem("number", String.valueOf(MyType.getNumber()));
		MyJson.AddItem("vendId", MyType.getVendermasterByvendid().getVendId());
		MyJson.AddItem("indate",  this.dateFm.format(MyType.getIndate()));
		MyJson.ItemOk();
		return MyJson.toString();
	}
	
	public String Item_SelectModelToJson(String item_id){
		HibernateDao.ItemgeneralDAO ItemgeneralDAO=new ItemgeneralDAO();
		Itemgeneral MyType = ItemgeneralDAO.findById(item_id);
		com.sanqing.common.json MyJson = new com.sanqing.common.json();
		MyJson.Reset();
		MyJson.set_success(true);
		MyJson.AddItem("prodCode", MyType.getClasscode().getProdId());//种类
		MyJson.AddItem("itemDesc", MyType.getItemDesc());//料品
		MyJson.AddItem("salePic", String.valueOf(MyType.getSalePic()));//单价
		MyJson.AddItem("wareId",MyType.getWarehouseBywareid().getWareId() );//仓库
		MyJson.AddItem("locaId",MyType.getLocationBylocationid().getLocaId() );//仓位
		MyJson.AddItem("vendId", MyType.getVendermasterByvendid().getVendId());//供应商
		MyJson.ItemOk();
		return MyJson.toString();
	}
	
	/**
	 * 
	 * @param MyType
	 * @return
	 */
	public boolean Item_Add(Intable MyType)
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
	public boolean Item_Edit(Intable MyType){
		Session session = D_ITEM.getSession();
		try{			
			Transaction MyAction = session.beginTransaction();
			Intable Temp = D_ITEM.findById(MyType.getId());
			Temp.setClasscode(MyType.getClasscode());
			Temp.setEmployeeByPoEmpId(MyType.getEmployeeByPoEmpId());
			Temp.setItemDesc(MyType.getItemDesc());
			Temp.setSalePic(MyType.getSalePic());
			Temp.setWarehouseBywareid(MyType.getWarehouseBywareid());
			Temp.setLocationBylocationid(MyType.getLocationBylocationid());
			Temp.setVendermasterByvendid(MyType.getVendermasterByvendid());
			/*Temp.setId(id);*/
			Temp.setNumber(MyType.getNumber());
			D_ITEM.save(Temp);
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
	public boolean Item_Delete(IntableId ID){
		Session session = D_ITEM.getSession();
		session.clear();
		try{
			Transaction MyAction = D_ITEM.getSession().beginTransaction();
			Intable MyType = D_ITEM.findById(ID);
			D_ITEM.delete(MyType);
			MyAction.commit();
		
		}
		catch(Exception eee){
			return false;
		}
		return true;
	}
	public boolean find_warehouseWarrant(IntableId id){
		Session session = D_ITEM.getSession();
		session.clear();
		try {
			Transaction MyAction = D_ITEM.getSession().beginTransaction();
			this.M_ITEM=this.D_ITEM.findById(id);
			MyAction.commit();
		
			if (this.M_ITEM==null) {
				return  false;
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
