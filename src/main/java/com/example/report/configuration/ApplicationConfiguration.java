package com.example.report.configuration;

import com.example.report.dao.UserDao;
import com.example.report.models.User;
import com.example.report.service.UserService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@org.springframework.context.annotation.Configuration
@ComponentScan("com.example.report")
public class ApplicationConfiguration {

    @Bean
    public SessionFactory userService() {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(UserDao.class)
                .addAnnotatedClass(UserService.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        return sessionFactory;
    }
}