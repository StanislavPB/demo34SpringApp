package org.demo34springapp.controller;


import lombok.AllArgsConstructor;
import org.demo34springapp.dto.taskDto.TaskCreateOrUpdateResponseDTO;
import org.demo34springapp.dto.taskDto.TaskCreateRequestDTO;
import org.demo34springapp.dto.taskDto.TaskResponseDTO;
import org.demo34springapp.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manager")
@AllArgsConstructor
public class ManagerController {

    private final TaskService taskService;

    @GetMapping(params = "managerName")
    public ResponseEntity<List<TaskResponseDTO>> findTaskByManagerName(@RequestParam String managerName){
        return new ResponseEntity<>(taskService.findTasksByManagerName(managerName), HttpStatus.OK);
    };


    @PostMapping
    public ResponseEntity<TaskCreateOrUpdateResponseDTO> createNewTask(@RequestBody TaskCreateRequestDTO request){
        return new ResponseEntity<>(taskService.createTask(request), HttpStatus.CREATED);
    };


}
