package com.github.java4wro.csvparser.controller;

import com.github.java4wro.csvparser.model.Hall;
import com.github.java4wro.csvparser.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
public class HallController {

    @Autowired
    HallService hallService;

    @PostMapping("/api/upload")
    public void createTable (@RequestParam("file")MultipartFile file) throws FileNotFoundException {
        try {
            hallService.readFile(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @GetMapping("/api/findall")
    public List<Hall> findAll (){
        return hallService.findAllSeats();
    }
}
