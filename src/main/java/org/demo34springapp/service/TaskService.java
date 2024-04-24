
package org.demo34springapp.service;

import lombok.AllArgsConstructor;
import org.demo34springapp.dto.taskDto.TaskCreateRequestDto;
import org.demo34springapp.dto.taskDto.TaskCreateResponseDto;
import org.demo34springapp.dto.taskDto.TaskResponseDto;
import org.demo34springapp.entity.Manager;
import org.demo34springapp.entity.Task;
import org.demo34springapp.entity.TaskStatus;
import org.demo34springapp.repository.TaskRepository;
import org.demo34springapp.service.exception.NotFoundException;
import org.demo34springapp.service.util.TaskConverter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository repository;
    private final ManagerService managerService;
    private final TaskConverter taskConverter;

    public List<TaskResponseDto>  findAll() {

//        List<Task> tasks = repository.findAll();
//        List<TaskResponseDto> dtos = new ArrayList<>();
//        for (Task task : tasks) {
//            TaskResponseDto dto = taskConverter.toDto(task);
//            dtos.add(dto);
//        }
//
//        return dtos;

        return repository.findAll().stream()
                .map(taskConverter::toDto)
                .toList();
    }

    public TaskResponseDto findById(Integer id){
        Task task = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task with id = " + id + " not found"));
        return taskConverter.toDto(task);

    }

    public TaskCreateResponseDto createTask(TaskCreateRequestDto request){

        Manager manager = managerService.findByManagerNameForCreateTask(request.getManagerName());

        Task newTask = taskConverter.fromCreateRequest(request);
        newTask.setManager(manager);

        LocalDateTime now = LocalDateTime.now();
        newTask.setCreateDate(now);
        newTask.setLastUpdate(now);

        newTask.setStatus(TaskStatus.OPEN);

        return taskConverter.toCreateDTO(repository.save(newTask));

    }

    public List<TaskResponseDto> findTasksByManagerName(String managerName) {

        Manager manager = managerService.findByManagerNameForCreateTask(managerName);

        return repository.findByManager(manager).stream()
                .map(taskConverter::toDto)
                .toList();

    }




}
