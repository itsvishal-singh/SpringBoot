package com.vishalspring.productlist;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductlistApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductlistApplication.class, args);
		MyApp myComponent = context.getBean(MyApp.class);
		myComponent.run();


		System.out.println("Hello");
	}

}
