package org.demo34springapp.repository;

import org.demo34springapp.entity.Manager;
import org.demo34springapp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
    List<Task> findByManager(Manager manager);
}
