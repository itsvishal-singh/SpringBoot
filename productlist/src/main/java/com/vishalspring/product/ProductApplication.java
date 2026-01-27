package com.vishalspring.product;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductApplication.class, args);
		MyApp myComponent = context.getBean(MyApp.class);
		myComponent.run();


		System.out.println("Hello");
	}

}
