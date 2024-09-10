package com.example.demo;

import com.example.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final Coach coach;

//    @Autowired
//    private Coach coach2;

    @Autowired
    public DemoController(@Qualifier("trackCoach") Coach coach1, @Qualifier("trackCoach") Coach coach2) {
        this.coach = coach1;

        var equal = coach1.equals(coach2);
        System.out.println("The objets are equal? " + equal);
        //@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) Yes
        //@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) No (Similar to transient)
    }

//    @Autowired
//    public void setCoach(Coach coach) {
//        this.coach = coach;
//    }

    @GetMapping("/daily-workout")
    public String getDailyWorkout() {

        return coach.getDailyWorkout();
    }
}
