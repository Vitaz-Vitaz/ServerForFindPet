package com.koribsky;

import com.koribsky.domain.NewPoint;
import com.koribsky.repository.NewPointRepository;
import com.koribsky.service.LibDemoService;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        context.getBean(LibDemoService.class).pointDemo();

        try {
            Console.main(args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}