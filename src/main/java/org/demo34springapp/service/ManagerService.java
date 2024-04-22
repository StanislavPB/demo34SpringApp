package org.demo34springapp.service;

import lombok.AllArgsConstructor;
import org.demo34springapp.dto.managerDTO.ManagerCreateRequestDto;
import org.demo34springapp.dto.managerDTO.ManagerCreateResponseDto;
import org.demo34springapp.entity.Manager;
import org.demo34springapp.entity.Role;
import org.demo34springapp.repository.ManagerRepository;
import org.demo34springapp.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ManagerService {

    private final ManagerRepository repository;
    private final RoleRepository roleRepository;



    public ManagerCreateResponseDto createManager(ManagerCreateRequestDto request){

        if (repository.findByManagerName(request.getManagerName()).isEmpty()) {
            Manager newManager = Manager.builder()
                    .managerName(request.getManagerName())
                    .password(request.getPassword())
                    .email(request.getEmail())
                    .build();
            Optional<Role> defaultRole = roleRepository.findByName("USER");

            if (defaultRole.isPresent()) {
                newManager.setRole(defaultRole.get());
            } else {
                throw new IllegalArgumentException("Role 'USER' not found");
            }

            Manager savedManager = repository.save(newManager);
            return ManagerCreateResponseDto.builder()
                    .id(savedManager.getId())
                    .managerName(savedManager.getManagerName())
                    .roleName(savedManager.getRole().toString())
                    .build();
        }

    }
}
