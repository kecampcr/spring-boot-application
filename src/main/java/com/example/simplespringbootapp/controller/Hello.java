package com.example.simplespringbootapp.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Hello {
    @Value("${spring.application.name}")
    private String appName;
    @Value("${info.app.version}")
    private String version;


    @RequestMapping(value = "/")
    public String sayHello() {
        String hostname = System.getenv("HOSTNAME");
        //log.debug("JAVA_HOME= "+ System.getenv("JAVA_HOME"));
        log.debug("HOSTNAME= " + hostname);
        return "<header><title>" +
                appName + "</title></header><div><h1>" + appName + "</h1></div><div><h2>HostName: " + hostname + " - Versión: "
                + version + "</h2></div>";

    }
}
