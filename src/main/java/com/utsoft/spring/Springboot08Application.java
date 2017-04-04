package com.utsoft.spring;

import com.utsoft.spring.dao.IUserDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 它也代表，启用 aop 的，只不过它是注解的方式。
// exposeProxy = true 等于 true 才能获取代理对象。
@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
public class Springboot08Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Springboot08Application.class, args);
        System.out.println("使用的是什么动态代理：" + context.getBean(IUserDao.class).getClass());
        context.getBean(IUserDao.class).add("kobe","mar");
		context.close();
	}
}
