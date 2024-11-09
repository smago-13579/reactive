package com.example;

import com.example.demo.config.DemoConfig;
import com.example.demo.service.DemoServiceOne;
import com.example.demo.service.DemoServiceThree;
import com.example.order.config.OrderConfig;
import com.example.order.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
		(scanBasePackageClasses = {OrderConfig.class, DemoConfig.class})
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		context.getBean(OrderService.class).createOrder();
		context.getBean(DemoServiceThree.class).handle("1");
//		context.getBean(DemoServiceOne.class).handle();
	}

//	@EventListener(ContextRefreshedEvent.class)
//	void print(String one) {
//		System.out.println(one);
//	}
}
