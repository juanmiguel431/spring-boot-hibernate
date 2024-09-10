package com.example.util;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
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

    // PreDestroy is not called on prototype scoped beans.
    @PreDestroy
    public void myDestroyStuff(){
        System.out.println("My destroying stuff " + this.getClass().getSimpleName());
    }
}
