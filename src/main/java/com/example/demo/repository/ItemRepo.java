package com.example.demo.repository;

import com.example.demo.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends CrudRepository<ItemEntity, Integer> {
}
