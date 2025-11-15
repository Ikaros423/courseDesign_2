package com.course.coursedesign2022.controller;

import com.course.coursedesign2022.service.ResearchRecruitment;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResearchRecruitmentController {
    @Autowired
    private  ResearchRecruitment researchRecruitment;

    @PutMapping("/researchRecruitment/{id}")
    public String researchRecruitment(@PathVariable Integer id)
    {
        boolean res = researchRecruitment.researchRecruitment(id);
        if (res){
            return "researchRecruitment updated";
        }
        return "researchRecruitment failed";}
}
