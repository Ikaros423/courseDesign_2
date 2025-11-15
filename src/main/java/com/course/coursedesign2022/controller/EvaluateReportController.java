package com.course.coursedesign2022.controller;

import com.course.coursedesign2022.service.EvaluateReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvaluateReportController {
    @Autowired
    private EvaluateReport evaluateReport;

    @PutMapping("/evaluateReport/{id}")
    public String evaluateReport(@PathVariable Integer id){
        boolean res = evaluateReport.evaluateReport(id);
        if (res){
            return "evaluateReport success";
        }
        return "evaluateReport failed";
    }
}
