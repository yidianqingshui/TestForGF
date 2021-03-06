/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.sanqing.struts.action;

import java.io.PrintWriter;

import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import HibernateDao.Employee;

import com.sanqing.struts.form.LoginForm;

/** 
 * MyEclipse Struts
 * Creation date: 04-15-2008
 * 
 * XDoclet definition:
 * @struts.action path="/login" name="loginForm" input="/form/login.jsp" scope="request" validate="true"
 * @struts.action-forward name="loginsuccess" path="/Frame.html"
 * @struts.action-forward name="loginfail" path="/form/login.jsp"
 */
public class LoginAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception
			{
			PrintWriter out = response.getWriter();
			LoginForm loginForm = (LoginForm) form;// TODO Auto-generated method stub
			com.sanqing.bll.BUserRight B_User = new com.sanqing.bll.BUserRight();
			if(
				B_User.ValidUser(loginForm.getUsername(), loginForm.getPassword())){
				//return mapping.findForward("loginsuccess");
				//获取登录者类型
					HibernateDao.EmployeeDAO D_EP = new HibernateDao.EmployeeDAO();
					Employee  Employee_instnce=	D_EP.findById(loginForm.getUsername());
				    String Employee_Role =Employee_instnce.getRole();
				    //把登录信息传到session
				    HttpSession  loginsession=   request.getSession();
				    loginsession.setAttribute("Username", loginForm.getUsername());
				    System.out.println(loginsession.getAttribute("Username"));
					if(Employee_Role.equals("1")){
						out.print("true");                       
					}
					else{
						out.print("true2");
					}
				}
			else{
				return mapping.findForward("loginfail");
			}
				return null;
	}
	
}