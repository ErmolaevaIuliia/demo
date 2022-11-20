package com.example.demo.repository;

import com.example.demo.entity.WatchEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchRepo extends CrudRepository<WatchEntity, Integer> {
}
