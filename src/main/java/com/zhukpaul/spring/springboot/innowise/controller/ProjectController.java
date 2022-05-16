package com.zhukpaul.spring.springboot.innowise.controller;

import com.zhukpaul.spring.springboot.innowise.entity.Project;
import com.zhukpaul.spring.springboot.innowise.exceptions.NoSuchProjectException;
import com.zhukpaul.spring.springboot.innowise.exceptions.IncorrectDataHandler;
import com.zhukpaul.spring.springboot.innowise.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public List<Project> showAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/projects/{proj_id}")
    public Project getProject(@PathVariable int proj_id) {
        Project project = projectService.getProject(proj_id);
        if(project == null) {
            throw new NoSuchProjectException("There is no project with id = " + proj_id);
        }
        return project;
    }

    @PostMapping("/projects")
    public Project saveProject(@RequestBody Project project) {
        projectService.saveProject(project);
        return project;
    }

    @PutMapping("/projects")
    public Project updateProject(@RequestBody Project project) {
        projectService.saveProject(project);
        return project;
    }

    @DeleteMapping("/projects/{proj_id}")
    public String deleteProject(@PathVariable int proj_id) {
        projectService.deleteProject(proj_id);
        return "Project with id = " + proj_id + " was deleted";
    }

}
