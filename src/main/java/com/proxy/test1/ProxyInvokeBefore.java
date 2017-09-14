package com.proxy.test1;


/**
 * 动态代理，方法执行前的处理类
 * @author gongjk
 *
 */
public class ProxyInvokeBefore {
	private Object obj;
    private ProxyInvokeBefore(){}
    private ProxyInvokeBefore(Object obj){
    	this.obj = obj;
    }
	 public static ProxyInvokeBefore getProxyInvokeBefore(Object obj){
		 return new ProxyInvokeBefore(obj);
	 }
	 public void excute(){
		 dataSourceSwitch();
	 }
	 /**
	  * 数据源切换
	  */
	 private void dataSourceSwitch(){
		 String invokeName = obj.getClass().getName();
         System.out.println("根据模块路径名确定切换到那个数据源:"+invokeName);
	 }
}
