package com.example.demo;

import com.example.util.Coach;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final Coach coach;

    public DemoController(Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/daily-workout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }
}
