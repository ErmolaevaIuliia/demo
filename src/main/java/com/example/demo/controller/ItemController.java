package com.example.demo.controller;

import com.example.demo.entity.ItemEntity;
import com.example.demo.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class ItemController {

    @Autowired
    private ItemRepo itemRepo;

    @PostMapping("/addItem")
    public String addItem(@ModelAttribute ItemEntity item){
    itemRepo.save(item);
    return "OK";
    }
}
