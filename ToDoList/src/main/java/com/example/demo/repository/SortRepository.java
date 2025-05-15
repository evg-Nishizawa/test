package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Sort;

public interface SortRepository extends JpaRepository<Sort, Integer> {

}
