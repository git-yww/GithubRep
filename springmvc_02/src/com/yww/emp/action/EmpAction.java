package com.yww.emp.action;

import java.util.Date;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.yww.emp.entity.Employee;
import com.yww.emp.service.IEmpService;

public class EmpAction extends AbstractCommandController{

	private IEmpService empService;

	public void setEmpService(IEmpService empService) {
		this.empService = empService;
	}

	//将表单参数封装到实体中
	public EmpAction(){
		this.setCommandClass(Employee.class);
	}

	//自定义一个String——>Date的转换器
	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, 
			Object obj, 
			BindException error)
					throws Exception {
		ModelAndView mav = new ModelAndView();

//		String hiredate = request.getParameter("hiredate");
//		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(hiredate);

		Employee emp = (Employee)obj;
//		emp.setHiredate(date);
		System.out.println(emp);
		System.out.println(emp.getHiredate());

		empService.register(emp);

		mav.addObject("message", "操作成功！");
		mav.addObject("emp", emp);
		mav.setViewName("success");

		return mav;
	}

}
