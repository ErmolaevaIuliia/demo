package com.example.demo.controller;

import com.example.demo.entity.WatchEntity;
import com.example.demo.repository.WatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/watch")
public class WatchController {

    @Value("${upload.path}")
    private String uploadFiles;

    @Autowired
    private WatchRepo watchRepo;

    @PostMapping("/addWatch")
    public String addWatch(@ModelAttribute WatchEntity watch,
                           @RequestParam("file") MultipartFile file) {
        File uploadDir = new File(uploadFiles);
        String uuidFile = UUID.randomUUID().toString();
        String fileName = uuidFile+"_"+file.getOriginalFilename();
        try {
            file.transferTo(new File(uploadDir+"/"+fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        watch.setImg(fileName);
        watchRepo.save(watch);
        return "OK";
    }

    @GetMapping("/getWatches")
    public ResponseEntity getWatches(){
    ArrayList<WatchEntity> watchEntities = (ArrayList<WatchEntity>) watchRepo.findAll();
    return ResponseEntity.ok(watchEntities);
    }
}
