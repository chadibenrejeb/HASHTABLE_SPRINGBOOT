package com.example.STAGEHASHTABLE.controller;


import com.example.STAGEHASHTABLE.service.HashTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/stagehashtable")
public class HashTableController {
    @Autowired
    private HashTableService service;

    @PostMapping("/add")
    public void addKey(@RequestBody String key) {
        service.addKey(key);
    }

    @DeleteMapping("/remove/{key}")
    public void removeKey(@PathVariable String key) {
        service.removeKey(key);
    }

    @GetMapping("/contains/{key}")
    public boolean containsKey(@PathVariable String key) {
        return service.containsKey(key);
    }

    @GetMapping("/display")
    public List<String> displayTable() {
        return service.getAllKeys().stream().map(entry -> entry.getKey()).toList();
    }

    @GetMapping("/size")
    public long getTableSize() {
        return service.getTableSize();
    }
}
