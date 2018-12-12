package com.log.filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/12/12
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app=new SpringApplication(Application.class);
        app.run(args);
    }
}
