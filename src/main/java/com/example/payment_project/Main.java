package com.example.payment_project;

import com.example.payment_project.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("app-config.xml");

        UserService userService = classPathXmlApplicationContext.getBean(UserService.class);
        System.out.println(userService);




    }
}
