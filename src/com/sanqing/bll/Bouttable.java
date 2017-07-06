package com.sanqing.bll;

import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.struts.action.ActionForm;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sanqing.struts.form.IntableForm;
import com.sanqing.struts.form.outtableForm;

import HibernateDao.*;

public class Bouttable {
	
	private HibernateDao.Outtable M_ITEM = new HibernateDao.Outtable();
	private HibernateDao.OuttableDAO D_ITEM = new HibernateDao.OuttableDAO();
	
	private SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd");
	public Bouttable(){}
	
	public String ItemsaddToHTMLTable(ActionForm form){
		//从IntableForm获取物料的信息
		outtableForm outtableForm = (outtableForm) form;
		StringBuilder HTML = new StringBuilder(""); 
		HTML.append("<tr>");
		HTML.append("<td>");
		HTML.append(outtableForm.getWarehouseWarrantOut());
		HTML.append("</td>");
		
		HTML.append("<td>");
		HTML.append(outtableForm.getItemId());
		HTML.append("</td>");
		
		HTML.append("<td>");
		HTML.append(outtableForm.getItemDesc());
		HTML.append("</td>");
		 
		HTML.append("<td>");
		HTML.append(outtableForm.getNumber());
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
			HTML.append(">");
			try{
				this.M_ITEM = (Outtable)Temp.next();
				
				HTML.append("<td>");
				HTML.append(this.M_ITEM.getId().getWarehouseWarrantOut());
				HTML.append("</td>");
				
				HTML.append("<td>");
				HTML.append(this.M_ITEM.getId().getItemId());
				HTML.append("</td>");
				
				HTML.append("<td>");
				HTML.append(this.M_ITEM.getItemDesc());
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
				HTML.append(this.M_ITEM.getOutdate());
				HTML.append("</td>");
				
			}catch(Exception eee){
				eee.printStackTrace();
			}
			
			HTML.append("</tr>");
		}
		String Temp1 = HTML.toString();
		return HTML.toString();
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
	 * @param VendID
	 * @return
	 */
	//相对应页面json的设置，各个框显示的内容定位
	public String Item_ConvertModelToJson(OuttableId id){
		Session session = D_ITEM.getSession();
		   session.clear();
		Outtable MyType = D_ITEM.findById(id);
		com.sanqing.common.json MyJson = new com.sanqing.common.json();
		MyJson.Reset();
		MyJson.set_success(true);
		MyJson.AddItem("itemDesc", MyType.getItemDesc());
		MyJson.AddItem("itemId",String.valueOf( MyType.getId().getItemId()));
		MyJson.AddItem("poEmpId", MyType.getEmployeeByPoEmpId().getEmpId());
		MyJson.AddItem("salePic", String.valueOf(MyType.getSalePic()));
		MyJson.AddItem("wareId",MyType.getWarehouseBywareid().getWareId());
		MyJson.AddItem("locaId",MyType.getLocationBylocationid().getLocaId() );
		MyJson.AddItem("warehouseWarrantOut",String.valueOf(MyType.getId().getWarehouseWarrantOut()));
		MyJson.AddItem("number", String.valueOf(MyType.getNumber()));
		MyJson.AddItem("vendId", MyType.getVendermasterByvendid().getVendId());
		MyJson.AddItem("outdate",  this.dateFm.format(MyType.getOutdate()));
		MyJson.AddItem("department", MyType.getDepartment().getDepartmengtId());
		MyJson.ItemOk();
		return MyJson.toString();
	}
	
	
	/**
	 * 
	 * @param MyType
	 * @return
	 */
	public boolean Item_Add(Outtable MyType)
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
		
		finally{		
			session.close();
		}
		return true;
	}
	
	/**
	 * �޸�����
	 * @return
	 */
	public boolean Item_Edit(Outtable MyType){
		Session session = D_ITEM.getSession();
		try{			
			Transaction MyAction = session.beginTransaction();
			Outtable Temp = D_ITEM.findById(MyType.getId());
			Temp.setEmployeeByPoEmpId(MyType.getEmployeeByPoEmpId());
			Temp.setItemDesc(MyType.getItemDesc());
			Temp.setSalePic(MyType.getSalePic());
			Temp.setWarehouseBywareid(MyType.getWarehouseBywareid());
			Temp.setLocationBylocationid(MyType.getLocationBylocationid());
			Temp.setVendermasterByvendid(MyType.getVendermasterByvendid());
			/*Temp.setItemId(MyType.getId().getItemId());*/
			Temp.setNumber(MyType.getNumber());
			Temp.setDepartment(MyType.getDepartment());
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
	public boolean Item_Delete(OuttableId ID){
		try{
			Transaction MyAction = D_ITEM.getSession().beginTransaction();
			Outtable MyType = D_ITEM.findById(ID);
			D_ITEM.delete(MyType);
			MyAction.commit();
		}
		catch(Exception eee){
			return false;
		}
		return true;
	}
	
	public boolean find_warehouseWarrantout(OuttableId id){
		try {
			this.M_ITEM=this.D_ITEM.findById(id);
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
