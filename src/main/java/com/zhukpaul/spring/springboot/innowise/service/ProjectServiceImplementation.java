package com.zhukpaul.spring.springboot.innowise.service;

import com.zhukpaul.spring.springboot.innowise.repository.ProjectRepository;
import com.zhukpaul.spring.springboot.innowise.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImplementation implements ProjectService{
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public void saveProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public Project getProject(int id) {
        Optional<Project> optional = projectRepository.findById(id);
        Project project = null;
        if(optional.isPresent()) {
            project = optional.get();
        }
        return project;
    }

    @Override
    public void deleteProject(int id) {
        projectRepository.deleteById(id);
    }
}
