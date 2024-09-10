package com.example.util;

public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("In constructor " + this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice for 15 minutes. Swim Coach.";
    }
}
