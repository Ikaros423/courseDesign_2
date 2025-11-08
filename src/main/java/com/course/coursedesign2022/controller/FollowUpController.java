package com.course.coursedesign2022.controller;

import com.course.coursedesign2022.service.FollowUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FollowUpController {
    @Autowired
    private FollowUp followUp;

    @PutMapping("/followUp/{id}")
    public String followUp(@PathVariable Integer id){
        boolean result = followUp.followUp(id);
        if(result){
            return "followUp updated";
        }
        return "followUp failed";
    }
}
