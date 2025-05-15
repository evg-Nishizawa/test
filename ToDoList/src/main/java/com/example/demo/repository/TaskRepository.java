package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    // @Query(value = "SELECT t.task_name, t.task_date, c.category_name, t.task_imp
    // FROM task t " +
    // "JOIN category c ON t.task_category = c.categoryId " +
    // "WHERE t.task_category = :categoryId", nativeQuery = true)
    @Query(value = "SELECT * FROM task " +
                    "WHERE task_category = :categoryId", nativeQuery = true)
    List<Task> catTask(@Param("categoryId") Integer categoryId);

    List<Task> findByCategory_categoryId(Integer categoryId);

    List<Task> findByCategory_categoryIdOrderByDateAsc(int categoryId);

    List<Task> findByCategory_categoryIdOrderByImpDesc(int categoryId);

    List<Task> findAllByOrderByDateAsc();

    List<Task> findAllByOrderByImpDesc();

    List<Task> findAllByOrderById();

}
