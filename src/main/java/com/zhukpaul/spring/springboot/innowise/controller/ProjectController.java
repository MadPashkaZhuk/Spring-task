package com.zhukpaul.spring.springboot.innowise.controller;

import com.zhukpaul.spring.springboot.innowise.entity.Project;
import com.zhukpaul.spring.springboot.innowise.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return projectService.getProject(proj_id);
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
