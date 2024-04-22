package org.demo34springapp.service.util;

import org.demo34springapp.dto.managerDTO.ManagerCreateRequestDto;
import org.demo34springapp.entity.Manager;

public class ManagerConverter {

    public Manager fromDto(ManagerCreateRequestDto request) {
        Manager newManager = new Manager();
        if (request.getManagerName() != null) {
            newManager.setManagerName(request.getManagerName());
        }
        if (request.getPassword() != null) {
            newManager.setPassword(request.getPassword());
        }
        if (request.getEmail() != null) {
            newManager.setEmail(request.getEmail());
        }

        return newManager;
    }
}
