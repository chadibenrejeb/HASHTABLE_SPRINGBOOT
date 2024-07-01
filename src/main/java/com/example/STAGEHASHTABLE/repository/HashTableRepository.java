    package com.example.STAGEHASHTABLE.repository;

    import com.example.STAGEHASHTABLE.model.HashTableEntry;
    import org.springframework.data.jpa.repository.JpaRepository;

    public interface HashTableRepository extends JpaRepository<HashTableEntry, Long> {
        boolean existsByKey(String key);
        void deleteByKey(String key);
    }
