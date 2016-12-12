package com.yww.hr.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.yww.hr.entity.Dept;
import com.yww.hr.entity.Employee;
import com.yww.hr.service.IDeptService;
import com.yww.hr.service.IEmployeeService;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>,RequestAware{
	
	/**
	 * 员工模块控制器
	 * 1.列表展示
	 * 2.添加员工
	 */

	private static final long serialVersionUID = 3139213636772308421L;

	/************封装数据************/
	private Map<String,Object> request;
	
	private int deptId;	//封装请求的部门id(下拉列表的实际值)
	
	private Employee employee = new Employee();		//【模型驱动】
	
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	@Override
	public Employee getModel() {
		return employee;
	}

	
	/**********注入Service**********/
	private IEmployeeService employeeService;
	
	private IDeptService deptService;
	
	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}
	
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	/**
	 * 1.员工列表展示
	 * @return
	 */
	public String list(){
		//查询所有员工
		List<Employee> listEmp = employeeService.getAll();
		
		//获取requet
		
		request.put("listEmp", listEmp);
		
		return "list";
	}
	
	/**
	 * 2.添加员工——跳转至添加页面
	 * @return
	 */
	public String addView(){
		
		//获取全部部门信息
		List<Dept> listDept = deptService.getAll();
		request.put("listDept",listDept);
		
		return "add";
	}
	
	/**
	 * 2.添加员工——保存员工到数据库
	 * @return
	 */
	public String save(){
		
		//根据选择的部门id查找出对应的部门
		Dept dept = deptService.findById(deptId);
		//将部门属性保存进员工对象中
		employee.setDept(dept);
		
		employeeService.save(employee);
		
		return "listAction";	//重定向
	}
	
	/**
	 * 3.修改员工——跳转至修改页面
	 * @return
	 */
	public String updateView(){
		
		//根据主键查找员工
		Employee emp = employeeService.findById(employee.getId());
		
		//查找所有的部门，存入request，在修改时使用
		List<Dept> listDept = deptService.getAll();
		
		//数据回显（其实就是将emp保存）
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.pop();
		vs.push(emp);
		
		//保存部门列表
		request.put("listDept", listDept);
		
		return "update";
	}
	
	/**
	 * 3.修改员工——将修改后的信息更新到数据库中
	 * @return
	 */
	public String update(){
		
		//根据部门id，查询部门对象
		Dept dept = deptService.findById(deptId);	//select标签中选择的值
		
		//将部门信息设置到员工属性中
		employee.setDept(dept);
		
		//更新员工
		employeeService.update(employee);
		
		return "listAction";
	}
	
	/**
	 * 4.删除员工
	 * @return
	 */
	public String delete(){
		
		//根据主键删除对象
		employeeService.delete(employee.getId());
		
		return "listAction";
	}
	
	public String search(){
		
		List<Employee> listEmp1 = employeeService.getAll(employee.getName());
		
		request.put("listEmp1", listEmp1);
		
		return "search";
	}

}
