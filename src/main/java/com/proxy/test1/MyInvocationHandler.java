package com.proxy.test1;

import java.lang.reflect.InvocationHandler;  
import java.lang.reflect.Method;
import org.apache.log4j.Logger;


public class MyInvocationHandler implements InvocationHandler{
	private Logger logger = Logger.getLogger(MyInvocationHandler.class);
    private Object target;  
    
    public MyInvocationHandler() {  
        super();  
    }  
  
    public MyInvocationHandler(Object target) {  
        super();  
        this.target = target;  
    }  
  
    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {  
        //执行方法前的处理
        ProxyInvokeBefore.getProxyInvokeBefore(target).excute(); 
        //执行逻辑方法 
        Object result = method.invoke(target, args);
        if(!"toString".equals(method.getName()))
        	logger.info("调用方法：" + target.getClass()+"."+method.getName() + "成功！");
        //方法执行后的处理
        ProxyInvokeAfter.getProxyInvokeAfter().excute();;

        return result;
    }
}
