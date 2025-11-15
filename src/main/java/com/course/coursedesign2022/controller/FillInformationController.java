package com.course.coursedesign2022.controller;

import com.course.coursedesign2022.service.FillInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FillInformationController {
    @Autowired
    private FillInformation fillInformation;

    @PutMapping("/fillInformation/{id}")
    public String fillInformation(@PathVariable Integer id){
        boolean res = fillInformation.fillInformation(id);
        if (res){
            return "fillInformation updated";
        }
        return "fillInformation failed";
    }
}
