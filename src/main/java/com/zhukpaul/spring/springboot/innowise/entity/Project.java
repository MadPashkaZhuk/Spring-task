package com.zhukpaul.spring.springboot.innowise.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

import java.util.List;

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


    @JsonManagedReference
    @OneToMany(mappedBy = "project",
            cascade = CascadeType.ALL)
    private List<Task> tasks;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
        task.setProject(this);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        task.setProject(null);
    }

}