package com.course.coursedesign2022.controller;

import com.course.coursedesign2022.service.BfzNote;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class BfzNoteController {
    @Autowired
    private BfzNote bfzNote;

    @PutMapping("/bfzNote/{id}")
    public String bfzNote(@PathVariable Integer id) {
        boolean res = bfzNote.bfzNote(id);
        if (res){
            return "bfzNote updated";
        }
        return "bfzNote failed";
    }
}
