package org.demo34springapp.service.util;


import org.demo34springapp.domain.Manager;
import org.demo34springapp.domain.Role;
import org.demo34springapp.dto.managerDto.ManagerCreateRequestDTO;
import org.demo34springapp.dto.managerDto.ManagerCreateResponseDTO;
import org.demo34springapp.dto.managerDto.ManagerResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class ManagerConverter {

    public ManagerCreateResponseDTO toCreateDto(Manager manager) {
        String role = manager.getRole().getName();
        return new ManagerCreateResponseDTO(manager.getId(), manager.getManagerName(), role);
    }

    public ManagerResponseDTO toDto(Manager manager) {
        Role role = manager.getRole();
        return new ManagerResponseDTO(manager.getId(), manager.getManagerName(), manager.getEmail(), role);
    }

    public Manager fromDto(ManagerCreateRequestDTO dto) {
        Manager newManager = new Manager();
        if (dto.getManagerName() != null) {
            newManager.setManagerName(dto.getManagerName());
        }
        if (dto.getPassword() != null) {
            newManager.setPassword(dto.getPassword());
            // newManager.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        if (dto.getEmail() != null) {
            newManager.setEmail(dto.getEmail());
        }

        return newManager;
    }
}
