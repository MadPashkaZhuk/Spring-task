package com.zhukpaul.spring.springboot.innowise.service;

import com.zhukpaul.spring.springboot.innowise.entity.Project;
import com.zhukpaul.spring.springboot.innowise.entity.Task;
import com.zhukpaul.spring.springboot.innowise.repository.ProjectRepository;
import com.zhukpaul.spring.springboot.innowise.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImplementation implements TaskService{
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Task> getAllTasksForProject(int id) {
        Optional<Project> optional = projectRepository.findById(id);
        Project project = null;
        if(optional.isEmpty()) {
            return null;
        }
        project = optional.get();
        return project.getTasks();
    }

    @Override
    public Task saveTaskForProject(int id, Task task) {
        return projectRepository.findById(id)
                .map(project -> {
            task.setProject(project);
            return taskRepository.save(task);
        }).get();
    }

    @Override
    public void deleteTaskForProject(int proj_id, int task_id) {
        taskRepository.findById(task_id)
                .map(task -> {
                    taskRepository.delete(task);
                    return "Delete is successful";
                });
    }
}
