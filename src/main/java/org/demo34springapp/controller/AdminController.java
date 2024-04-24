package org.demo34springapp.controller;

import lombok.AllArgsConstructor;
import org.demo34springapp.dto.managerDto.ManagerCreateRequestDTO;
import org.demo34springapp.dto.managerDto.ManagerCreateResponseDTO;
import org.demo34springapp.service.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);
    private final ManagerService managerService;

    @PostMapping
    public ResponseEntity<ManagerCreateResponseDTO> createManager(@RequestBody ManagerCreateRequestDTO request) {
        //log.info("Start controller createManager"); - плохой вариант
        return new ResponseEntity<>(managerService.createManager(request), HttpStatus.CREATED);
    }
}
