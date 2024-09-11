package net.engineeringdigest.journalApp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Health")
public class HealthCheck {

   

    @GetMapping
    public String healthCheck(){
        return "ok";

    }
    @PostMapping("/health-post")
    public String healthpost(){
        return "running succuesfully";
    }

    @GetMapping("/st")
    public String backchodi(){

        return "STUDENT IS WORKONG ON PROJECT ";
    }
}
