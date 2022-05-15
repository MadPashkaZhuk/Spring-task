package com.zhukpaul.spring.springboot.innowise.repository;

import com.zhukpaul.spring.springboot.innowise.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
