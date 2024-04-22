package org.demo34springapp.repository;

import org.demo34springapp.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    public Optional<Manager> findByManagerName(String name);
}
