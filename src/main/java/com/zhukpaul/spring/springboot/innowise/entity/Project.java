package com.zhukpaul.spring.springboot.innowise.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "proj_id"
    )
    private Integer id;
    @Column(
            name = "proj_name"
    )
    private String proj_name;
    @Column(
            name = "proj_description"
    )
    private String description;

    public Project() {
    }

    public Project(String proj_name, String description) {
        this.proj_name = proj_name;
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProj_name() {
        return this.proj_name;
    }

    public void setProj_name(String proj_name) {
        this.proj_name = proj_name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}