/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.sanqing.struts.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import HibernateDao.Employee;
import HibernateDao.Intable;
import HibernateDao.IntableId;
import HibernateDao.Itemgeneral;
import HibernateDao.Outtable;
import HibernateDao.OuttableId;

import com.sanqing.struts.form.IntableForm;
import com.sanqing.struts.form.outtableForm;

public class outtableAction extends Action {
	/*
	 * Generated Methods
	 */

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession out_addsession=   request.getSession();
		outtableForm outtableForm = (outtableForm) form;
		OuttableId id =new OuttableId(outtableForm.getWarehouseWarrantOut(), outtableForm.getItemId());
		//System.out.println(IntableForm.getWarehouseWarrant());前台数据传过来了
		try{
			PrintWriter out = response.getWriter();
			try{
			  String oper = request.getParameter("oper");
			  System.out.println("前台操作标志"+oper);
				com.sanqing.bll.Bouttable B_V = new com.sanqing.bll.Bouttable();
				com.sanqing.bll.BItemGeneral item_B_V = new com.sanqing.bll.BItemGeneral();
				 if(oper.equals("add_to_intable")){
					 String name ="outtable";
					String addid=String.valueOf(outtableForm.getItemId());
					out_addsession.setAttribute(name+addid, outtableForm);//把物料信息先放到session里面			
					out.print(B_V.ItemsaddToHTMLTable(outtableForm));
				  }			
				 else	if(("add").equals(oper))
				{
					 Enumeration   e =	request.getSession().getAttributeNames();
					 String name ="outtable";
					 while(e.hasMoreElements())
						{			
							String sessionName=(String)e.nextElement().toString();             
							if(sessionName.indexOf(name)!=-1){  
								Object session_ab=out_addsession.getAttribute(sessionName);		
								HibernateDao.Outtable TypeModel = new HibernateDao.Outtable();	
								HibernateDao.OuttableId out_TypeModel_id =new OuttableId();
								outtableForm  out_add_IntableForm =	(com.sanqing.struts.form.outtableForm) session_ab;	
					TypeModel.setEmployeeByPoEmpId(new HibernateDao.EmployeeDAO().findById(out_add_IntableForm.getPoEmpId()));				
					TypeModel.setItemDesc(out_add_IntableForm.getItemDesc());
					out_TypeModel_id.setItemId(out_add_IntableForm.getItemId());
					out_TypeModel_id.setWarehouseWarrantOut(out_add_IntableForm.getWarehouseWarrantOut());
					TypeModel.setId(out_TypeModel_id);
					TypeModel.setSalePic( out_add_IntableForm.getSalePic());
					TypeModel.setWarehouseBywareid(new HibernateDao.WarehouseDAO().findById(out_add_IntableForm.getWareId()));
					TypeModel.setLocationBylocationid(new HibernateDao.LocationDAO().findById(out_add_IntableForm.getLocaId()));
					TypeModel.setVendermasterByvendid(new HibernateDao.VendermasterDAO().findById(out_add_IntableForm.getVendId()));
					TypeModel.setDepartment(new HibernateDao.DepartmentDAO().findById(out_add_IntableForm.getDepartment()));
					//String与date之间的转换
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date date=sdf.parse(out_add_IntableForm.getoutdate()); 
					System.out.println(date);
					TypeModel.setOutdate(date);	
					TypeModel.setNumber(out_add_IntableForm.getNumber());
		
					HibernateDao.ItemgeneralDAO  ItemgeneralDAO=new HibernateDao.ItemgeneralDAO();
					Itemgeneral   instance=	ItemgeneralDAO.findById(String.valueOf(out_add_IntableForm.getItemId()));
					Integer	instance_number=	instance.getNumber();
					instance.setNumber(instance_number-outtableForm.getNumber());
					B_V.Item_Add(TypeModel);
							}
				}
						out.print(B_V.ItemsConvertToHTMLTable());	
						}
				else if(oper.equals("edit"))
				{
					HibernateDao.Outtable TypeModel = new HibernateDao.Outtable();
					//TypeModel.setClasscode(new HibernateDao.ClasscodeDAO().findById(outtableForm.getProdCode()));
					//TypeModel.setColor(itemeditorForm.getColor());
					TypeModel.setEmployeeByPoEmpId(new HibernateDao.EmployeeDAO().findById(outtableForm.getPoEmpId()));
					TypeModel.setItemDesc(outtableForm.getItemDesc());			
					TypeModel.setSalePic(outtableForm.getSalePic());
					TypeModel.setWarehouseBywareid(new HibernateDao.WarehouseDAO().findById(outtableForm.getWareId()));
					TypeModel.setLocationBylocationid(new HibernateDao.LocationDAO().findById(outtableForm.getLocaId()));
					TypeModel.setDepartment(new HibernateDao.DepartmentDAO().findById(outtableForm.getDepartment()));
					TypeModel.setVendermasterByvendid(new HibernateDao.VendermasterDAO().findById(outtableForm.getVendId()));
					/*//先获取库存里面的数量
					HibernateDao.ItemgeneralDAO D_ITEM = new HibernateDao.ItemgeneralDAO();
					Itemgeneral MyType = D_ITEM.findById(String.valueOf(outtableForm.getItemId()));
					Integer StorsgeValue= MyType.getNumber();//数据库库存为StorsgeValue
					System.out.println("库存"+StorsgeValue);				
				    TypeModel.setNumber(outtableForm.getNumber());
					//入库的数量为IntableForm.getNumber()
					System.out.println("入库量："+outtableForm.getNumber());
					HibernateDao.Itemgeneral item_TypeModel = new HibernateDao.Itemgeneral();
					item_TypeModel.setNumber(StorsgeValue+outtableForm.getNumber());*/
		              
					B_V.Item_Edit(TypeModel);
				}
				else if(oper.equals("lookup")){
					HibernateDao.Outtable Outtable=new HibernateDao.Outtable();
					com.sanqing.bll.Bouttable Bouttable =new com.sanqing.bll.Bouttable();
					int warehouseWarrant_out=Integer.parseInt(request.getParameter("warehouseWarrantOut"));
					if (Bouttable.find_warehouseWarrantout(id)) {
					out.print(B_V.Item_ConvertModelToJson(id));
					}
					else{
						out.print("flase");		
					}
					return null;
				}
				else if(oper.equals("select")){
					//建立物料的实体类
					out.print(B_V.Item_SelectModelToJson(request.getParameter("itemId")));
				}
				else if(oper.equals("delete"))
				{
					HibernateDao.OuttableId intable_id =new OuttableId(Integer.parseInt(request.getParameter("warehouseWarrant")), Integer.parseInt(request.getParameter("itemId")));
					B_V.Item_Delete(intable_id);
				}
				else if(oper.equals("model"))
				{
					OuttableId out_id =new OuttableId(Integer.parseInt(request.getParameter("warehouseWarrant")), Integer.parseInt(request.getParameter("itemId")));
					out.print(B_V.Item_ConvertModelToJson(out_id));
					return null;
				}
				else{
				out.print(B_V.ItemsConvertToHTMLTable());	
				}
			}catch(Exception e){
				out.print(e.getMessage());
			}
			
		}
		catch(IOException e1){
			e1.printStackTrace();
		}
		return null;
	}
}