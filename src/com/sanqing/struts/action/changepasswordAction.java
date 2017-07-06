package com.sanqing.struts.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Transaction;

import HibernateDao.Employee;

import com.sanqing.struts.form.UserEditorForm;

public class changepasswordAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获取当前登录者用户名
		HttpSession  loginsession=   request.getSession();
		String LoginName =(String) loginsession.getAttribute("Username");
		
		//System.out.println(LoginName);
		HibernateDao.EmployeeDAO D_EP = new HibernateDao.EmployeeDAO();
		Transaction MyAction = D_EP.getSession().beginTransaction();
		
		UserEditorForm UserEditorForm = (UserEditorForm) form;
		PrintWriter out = response.getWriter();
		
		HibernateDao.Employee  employee	=D_EP.findById(LoginName);//从数据库找到登录者注册的数据
	    System.out.println("表单提交："+UserEditorForm.getPassword_ed());
	    System.out.println("从数据库获取："+employee.getPassword());
		if (!(employee.getPassword().equals(UserEditorForm.getPassword_ed()))) {
		   out.print("Password_ed_flase");     
	   }
	   else if (!(UserEditorForm.getPassword_new().equals(UserEditorForm.getPassword()))) {
		   out.print("Password_same_flase");     
	   }
	   else{
		employee.setPassword(UserEditorForm.getPassword());
		D_EP.save(employee);
		MyAction.commit();
		out.print("true");
	   }
		return null;
		
	}
}
