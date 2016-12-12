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
	 * Ա��ģ�������
	 * 1.�б�չʾ
	 * 2.���Ա��
	 */

	private static final long serialVersionUID = 3139213636772308421L;

	/************��װ����************/
	private Map<String,Object> request;
	
	private int deptId;	//��װ����Ĳ���id(�����б��ʵ��ֵ)
	
	private Employee employee = new Employee();		//��ģ��������
	
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

	
	/**********ע��Service**********/
	private IEmployeeService employeeService;
	
	private IDeptService deptService;
	
	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}
	
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	/**
	 * 1.Ա���б�չʾ
	 * @return
	 */
	public String list(){
		//��ѯ����Ա��
		List<Employee> listEmp = employeeService.getAll();
		
		//��ȡrequet
		
		request.put("listEmp", listEmp);
		
		return "list";
	}
	
	/**
	 * 2.���Ա��������ת�����ҳ��
	 * @return
	 */
	public String addView(){
		
		//��ȡȫ��������Ϣ
		List<Dept> listDept = deptService.getAll();
		request.put("listDept",listDept);
		
		return "add";
	}
	
	/**
	 * 2.���Ա����������Ա�������ݿ�
	 * @return
	 */
	public String save(){
		
		//����ѡ��Ĳ���id���ҳ���Ӧ�Ĳ���
		Dept dept = deptService.findById(deptId);
		//���������Ա����Ա��������
		employee.setDept(dept);
		
		employeeService.save(employee);
		
		return "listAction";	//�ض���
	}
	
	/**
	 * 3.�޸�Ա��������ת���޸�ҳ��
	 * @return
	 */
	public String updateView(){
		
		//������������Ա��
		Employee emp = employeeService.findById(employee.getId());
		
		//�������еĲ��ţ�����request�����޸�ʱʹ��
		List<Dept> listDept = deptService.getAll();
		
		//���ݻ��ԣ���ʵ���ǽ�emp���棩
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.pop();
		vs.push(emp);
		
		//���沿���б�
		request.put("listDept", listDept);
		
		return "update";
	}
	
	/**
	 * 3.�޸�Ա���������޸ĺ����Ϣ���µ����ݿ���
	 * @return
	 */
	public String update(){
		
		//���ݲ���id����ѯ���Ŷ���
		Dept dept = deptService.findById(deptId);	//select��ǩ��ѡ���ֵ
		
		//��������Ϣ���õ�Ա��������
		employee.setDept(dept);
		
		//����Ա��
		employeeService.update(employee);
		
		return "listAction";
	}
	
	/**
	 * 4.ɾ��Ա��
	 * @return
	 */
	public String delete(){
		
		//��������ɾ������
		employeeService.delete(employee.getId());
		
		return "listAction";
	}
	
	public String search(){
		
		List<Employee> listEmp1 = employeeService.getAll(employee.getName());
		
		request.put("listEmp1", listEmp1);
		
		return "search";
	}

}
