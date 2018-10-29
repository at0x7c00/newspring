package me.huqiao.newspring.proxy;

import java.lang.reflect.Method;

import org.junit.Test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * CGLib可以为任意类创建代理对象
 */
public class CGLibProxyTest {

	@Test
	public void test() {
		CGLibProxy proxy = new CGLibProxy();
		
		//Enhancer是关键，它指明要增强谁，以及增强的动作
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(SomeService.class);//代理类继承于被代理类
		enhancer.setCallback(proxy);//设置代理动作：即设置被代理类方法被调用时触发的动作
		
		SomeService service = (SomeService)enhancer.create();
		service.doService();
		service.doService2();
	}
	
}
class SomeService {
	public void doService() {
		System.out.println("Do SomeService...");
	}
	public void doService2() {
		System.out.println("Do SomeService2...");
	}
}
class CGLibProxy implements MethodInterceptor{

	/**
	 * proxy：被代理对象方法
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		//这就是面向切面：正常的调用干涉一下，能看到正在调用谁，从而判断是否需要做点儿什么
		System.out.println(proxy.getSignature().getName());
		System.out.println("Do enhancer intercept...");
		System.out.println("Before invoke");
		//调用父类方法就是调用被代理对象本身的方法
		//如果这里再调用proxy.invoke(obj, args)，则会陷入死循环了
		Object res = proxy.invokeSuper(obj, args);
		System.out.println("After invoke");
		return res;
	}
	
}
