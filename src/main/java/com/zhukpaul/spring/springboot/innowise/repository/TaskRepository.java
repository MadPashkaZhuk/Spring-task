package com.zhukpaul.spring.springboot.innowise.repository;

import com.zhukpaul.spring.springboot.innowise.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
