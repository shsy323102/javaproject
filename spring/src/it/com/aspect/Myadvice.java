package it.com.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class Myadvice {
	
	public void before(){
		System.out.println("����ǰ��֪ͨ!!");
	}
	//����֪ͨ
	public void afterReturning(){
		System.out.println("���Ǻ���֪ͨ(��������쳣�������)!!");
	}
	//����֪ͨ
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("���ǻ���֪֮ͨǰ�Ĳ���!!");
		Object proceed = pjp.proceed();//����Ŀ�귽��
		System.out.println("���ǻ���֪֮ͨ��Ĳ���!!");
		return proceed;
	}
	//�쳣֪ͨ
	public void afterException(){
		System.out.println("������!�����쳣��!!");
	}
	//����֪ͨ
	public void after(){
		System.out.println("���Ǻ���֪ͨ(�����쳣Ҳ�����)!!");
	}

}
