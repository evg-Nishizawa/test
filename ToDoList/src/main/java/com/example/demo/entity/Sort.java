package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sort")
public class Sort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sort_id")
    private int sortId;
    @Column(name = "sort_name")
    private String sortName;

    public Sort() {

    }

    public int getSortId() {
        return sortId;
    }

    public String getSortName() {
        return sortName;
    }
}
