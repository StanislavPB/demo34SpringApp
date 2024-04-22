package org.demo34springapp.service;

import lombok.AllArgsConstructor;
import org.demo34springapp.entity.Manager;
import org.demo34springapp.repository.ManagerRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ManagerService {

    private final ManagerRepository repository;

    public void createManager(){

    }
}
