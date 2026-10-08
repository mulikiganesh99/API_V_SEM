package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A small REST endpoint that documents, at runtime, which Spring Framework
 * modules this project exercises: Core Container (IoC/DI, demonstrated by
 * this bean itself being managed by the container), Data Access/Integration
 * (spring-boot-starter-jdbc, wired via JdbcTemplate elsewhere in the lab),
 * and Web (spring-boot-starter-web / Spring MVC, demonstrated by this
 * controller).
 */
@RestController
public class ModuleInfoController {

    @GetMapping("/modules")
    public String modules() {
        return "Core Container: Beans/Core/Context/SpEL (IoC + DI) | "
                + "Data Access/Integration: JDBC/ORM/Transaction | "
                + "Web (MVC): Web/Web-Servlet";
    }
}
