package com.example.util;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TrackCoach implements Coach {

    public TrackCoach() {
        System.out.println("In constructor " + this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes. Track Coach.";
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
