package com.proxy.test1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.proxy.test2.HelloTest;
import com.proxy.test2.HelloTestImpl;

/**
 * 调用不同Service的入口
 * @author gongjk
 *
 */
public class InvokeProxy {
    /**
     * 对外执行接口
     * @param obj:接口对象
     * @throws Exception 
     */
    public static <T> T execute(Object obj) throws Exception{
    	Object targetObj = AopTargetUtils.getTarget(obj);
        InvocationHandler invocationHandler = new MyInvocationHandler(targetObj);  
        return (T)Proxy.newProxyInstance(targetObj.getClass().getClassLoader(),  
        		targetObj.getClass().getInterfaces(), invocationHandler);  
    	
    }

    public static void main(String[] args) {  
    	
		//设置为true,会在工程根目录生成$Proxy0.class代理类（com.sun.proxy.$Proxy0.class）
		System.getProperties().put(
				"sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
    	
    	InvokeProxy mainTest = new InvokeProxy();
        HelloTest helloWordService = new HelloTestImpl();  
        HelloTest helloWordServiceProxy;
		try {
			helloWordServiceProxy = (HelloTest)mainTest.execute(helloWordService);
			helloWordServiceProxy.say("123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }  

}
