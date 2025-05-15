package com.example.demo.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class TaskList {
    private int comp;
    private String name;
    private LocalDate date;
    private String catName;
    private int imp;

    public TaskList() {

    }

    public TaskList(int comp, String name, LocalDate date, String catName, int imp) {
        this.comp = comp;
        this.name = name;
        this.date = date;
        this.catName = catName;
        this.imp = imp;
    }

    public int getComp() {
        return comp;
    }

    public void setComp(int comp) {
        this.comp = comp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCatName() {
        return catName;
    }

    public void setCategoryName(String catName) {
        this.catName = catName;
    }

    public int getImp() {
        return imp;
    }

    public void setImp(int imp) {
        this.imp = imp;
    }

}
