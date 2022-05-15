package com.zhukpaul.spring.springboot.innowise.service;

import com.zhukpaul.spring.springboot.innowise.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasksForProject(int proj_id);

    Task saveTaskForProject(int proj_id, Task task);

    void deleteTaskForProject(int proj_id, int task_id);
}
