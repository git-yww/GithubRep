package com.yww.hr.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * �Է��ʵ��û���������У��
 * ֻ�е�¼����ܽ��в���
 * û�е�¼��ֻ�ܲ鿴�б����ܲ���
 * 
 * @author IVAN
 *
 */
public class UserLoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 2942821527391563816L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
	
		//��ȡ��ǰִ�еķ���(invocation.getProxy()���ص���ActionProxy)
		String methodName = invocation.getProxy().getMethod();
		
		//��ȡsession,�����л�ȡ��½�Ĺ���Ա��Ϣ
		ActionContext ac = invocation.getInvocationContext();
		Object obj = ac.getSession().get("adminBack");
		
		//�ж��Ƿ���login������list����
		if("login".equals(methodName) || "list".equals(methodName) || "register".equals(methodName)){
			
			//����ִ��action
			return invocation.invoke();
		}else{
			
			//û�е�¼����ת����½ҳ��
			//��¼�������ִ��action
			return obj == null ? "login" : invocation.invoke();
		}
	}

}
