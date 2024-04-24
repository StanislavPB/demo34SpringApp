package org.demo34springapp.service;

import lombok.RequiredArgsConstructor;
import org.demo34springapp.domain.Manager;
import org.demo34springapp.domain.Role;
import org.demo34springapp.dto.managerDto.ManagerCreateRequestDTO;
import org.demo34springapp.dto.managerDto.ManagerCreateResponseDTO;
import org.demo34springapp.dto.managerDto.ManagerResponseDTO;
import org.demo34springapp.repository.ManagerRepository;
import org.demo34springapp.repository.RoleRepository;
import org.demo34springapp.service.exception.AlreadyExistException;
import org.demo34springapp.service.exception.NotFoundException;
import org.demo34springapp.service.util.ManagerConverter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final ManagerRepository repository;
    private final RoleRepository roleRepository;
    private final ManagerConverter converter;

    public ManagerResponseDTO findByManagerName(String managerName) {
        Manager manager = repository.findByManagerName(managerName)
                .orElseThrow(() -> new NotFoundException("Manager with name " + managerName + " not found"));
        return converter.toDto(manager);
    }

    public Manager findByManagerNameForCreateTask(String managerName) {
        return repository.findByManagerName(managerName)
                .orElseThrow(() -> new NotFoundException("Manager with name " + managerName + " not found"));

    }

    public ManagerCreateResponseDTO createManager(ManagerCreateRequestDTO request){
        if (repository.findByManagerName(request.getManagerName()).isEmpty()) {
            Manager newManager = converter.fromDto(request);
            Optional<Role> defaultRole = roleRepository.findByName("USER");

            if (defaultRole.isPresent()) {
                newManager.setRole(defaultRole.get());
            } else {
                throw new NotFoundException("Role 'USER' not found!");
            }

            Manager savedmanager = repository.save(newManager);
            return converter.toCreateDto(savedmanager);
        } else {
            throw new AlreadyExistException("Manager with name " + request.getManagerName() + " is already exist!");
        }
    }
}
