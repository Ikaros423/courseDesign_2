package com.course.coursedesign2022.controller;

import com.course.coursedesign2022.service.ExtendedActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExtendedActivityController {
    @Autowired
    private ExtendedActivity extendedActivity;

    @PutMapping("/extendedActivity/{id}")
    public String extendedActivity(@PathVariable Integer id) {
        boolean res = extendedActivity.extendedActivity(id);
        if (res) {
            return "extendedActivity updated";
        }
        return "extendedActivity failed";
    }
}
