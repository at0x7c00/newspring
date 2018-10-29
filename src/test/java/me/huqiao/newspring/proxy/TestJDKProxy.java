package me.huqiao.newspring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

/**
 * JDK动态代理的缺点：只能为接口创建代理
 * @author lipanpan
 */
public class TestJDKProxy {

	@Test
	public void test() {
		
		//实际对象
		Service service = new ServiceImpl();
		
		//代理对象
		ServoceInvocationHandler handler = new ServoceInvocationHandler(service);
		
		//连接，构建代理对象
		Service serviceProxy = (Service)Proxy.newProxyInstance(service.getClass().getClassLoader(), 
				service.getClass().getInterfaces(),
				handler);
		
		//用代理对象进行调用
		serviceProxy.doService();
		
		System.out.println(serviceProxy.getClass().getName());
		for(Class c : serviceProxy.getClass().getInterfaces()) {
			System.out.println(c.getName());
		}
	}
}

interface Service{
	void doService();
}

class ServiceImpl implements Service{

	@Override
	public void doService() {
		System.out.println("Do Service...");
	}
}

class ServoceInvocationHandler implements InvocationHandler{

	private Object target;
	public ServoceInvocationHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Before do service");
		Object obj = method.invoke(target, args);
		System.out.println("After do service");
		return obj;
	}
	
}