package com.vishalproduct;

import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    public MyComponent(){
        System.out.println("Message from MyComponent");
    }
    public  void getMessage(){
        System.out.println("Message from getMessage");
    }
}
