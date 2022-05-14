package com.zhukpaul.spring.springboot.innowise.service;


import com.zhukpaul.spring.springboot.innowise.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProjects();

    void saveProject(Project project);

    Project getProject(int id);

    void deleteProject(int id);
}
