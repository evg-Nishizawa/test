package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int id;

    // categoryテーブルから同じカテゴリーIDの値を取る
    @ManyToOne
    @JoinColumn(name = "task_category", referencedColumnName = "category_id")
    private Category category;

    @Column(name = "task_name")
    private String name;

    @Column(name = "task_date")
    private LocalDate date;

    @Column(name = "task_imp")
    private Integer imp;

    @Column(name = "task_comp")
    private Integer comp;

    public Task() {

    }

    public Task(String name, LocalDate date, Category category) {
        this.category = category;
        this.name = name;
        this.date = date;
        imp = 0;
        comp = 0;
    }

    public Task(String name, LocalDate date, Category category, Integer imp) {
        this.category = category;
        this.name = name;
        this.date = date;
        this.imp = imp;
        comp = 0;
    }

    public Task(String name, LocalDate date, Category category, Integer imp, Integer comp) {
        this.category = category;
        this.name = name;
        this.date = date;
        this.imp = imp;
        this.comp = comp;
    }

    public Task(Integer comp) {
        this.comp = comp;
    }

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getImp() {
        return imp;
    }

    public Integer getComp() {
        return comp;
    }

    public void setComp(Integer comp) {
        this.comp = comp;
    }

    public void setTask(String name, LocalDate date, Category category) {
        this.category = category;
        this.name = name;
        this.date = date;
        imp = 0;
        comp = 0;
    }

    public void setTask(String name, LocalDate date, Category category, Integer imp) {
        this.category = category;
        this.name = name;
        this.date = date;
        this.imp = imp;
        comp = 0;
    }

}
