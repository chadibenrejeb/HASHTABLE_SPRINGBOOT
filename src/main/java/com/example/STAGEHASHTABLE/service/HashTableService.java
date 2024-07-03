package com.example.STAGEHASHTABLE.service;


import com.example.STAGEHASHTABLE.model.HashTableEntry;
import com.example.STAGEHASHTABLE.repository.HashTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HashTableService {
    @Autowired
    private HashTableRepository repository;

    @Transactional
    public void addKey(String key) {
        if (!repository.existsByKey(key)) {
            HashTableEntry entry = new HashTableEntry();
            entry.setKey(key);
            repository.save(entry);
        }
    }

    @Transactional
    public void removeKey(String key) {
        repository.deleteByKey(key);
    }

    @Transactional(readOnly = true)
    public boolean containsKey(String key) {
        return repository.existsByKey(key);
    }

    @Transactional(readOnly = true)
    public List<HashTableEntry> getAllKeys() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public long getTableSize() {
        return repository.count();
    }
}
