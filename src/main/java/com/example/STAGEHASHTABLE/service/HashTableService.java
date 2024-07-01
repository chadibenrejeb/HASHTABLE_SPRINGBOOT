package com.example.STAGEHASHTABLE.service;


import com.example.STAGEHASHTABLE.model.HashTableEntry;
import com.example.STAGEHASHTABLE.repository.HashTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HashTableService {
    @Autowired
    private HashTableRepository repository;

    public void addKey(String key) {
        if (!repository.existsByKey(key)) {
            HashTableEntry entry = new HashTableEntry();
            entry.setKey(key);
            repository.save(entry);
        }
    }

    public void removeKey(String key) {
        repository.deleteByKey(key);
    }

    public boolean containsKey(String key) {
        return repository.existsByKey(key);
    }

    public List<HashTableEntry> getAllKeys() {
        return repository.findAll();
    }

    public long getTableSize() {
        return repository.count();
    }
}
