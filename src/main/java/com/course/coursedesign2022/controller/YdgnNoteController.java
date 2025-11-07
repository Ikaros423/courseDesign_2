package com.course.coursedesign2022.controller;

import com.course.coursedesign2022.service.YdgnNote;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class YdgnNoteController {
    @Autowired
    private YdgnNote ydgnNote;

    @PutMapping("/ydgnNote/{id}")
    public String ydgnNote(@PathVariable Integer id) {
        boolean res = ydgnNote.YdgnNote(id);
        if (res){
            return "ydgnNote updated";
        }
        return "ydgnNote failed";
    }
}
