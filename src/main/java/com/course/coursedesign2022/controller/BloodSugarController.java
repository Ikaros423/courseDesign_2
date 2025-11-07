package com.course.coursedesign2022.controller;

import com.course.coursedesign2022.service.BloodSugar;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class BloodSugarController {

    @Autowired
    private BloodSugar bloodSugar;

    @PutMapping("/bloodSugar/{id}")
    public String bloodSugar(@PathVariable Integer id) {
        boolean res = bloodSugar.bloodSugar(id);
        if (res){
            return "bloodSugar updated";
        }
        return "bloodSugar failed";
    }
}
