package com.example.util;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Lazy
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor " + this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice for 15 minutes. Cricket Coach.";
    }

    @PostConstruct
    public void myInitializationStuff(){
        System.out.println("My initialization stuff " + this.getClass().getSimpleName());
    }

    @PreDestroy
    public void myDestroyStuff(){
        System.out.println("My destroying stuff " + this.getClass().getSimpleName());
    }
}
