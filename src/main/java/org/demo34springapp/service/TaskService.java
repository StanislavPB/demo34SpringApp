package org.demo34springapp.service;

import lombok.AllArgsConstructor;
import org.demo34springapp.domain.Manager;
import org.demo34springapp.domain.Task;
import org.demo34springapp.domain.TaskStatus;
import org.demo34springapp.dto.taskDto.TaskCreateOrUpdateResponseDTO;
import org.demo34springapp.dto.taskDto.TaskCreateRequestDTO;
import org.demo34springapp.dto.taskDto.TaskResponseDTO;
import org.demo34springapp.repository.TaskRepository;
import org.demo34springapp.service.exception.NotFoundException;
import org.demo34springapp.service.util.TaskConverter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final ManagerService managerService;
    private final TaskConverter converter;

    public List<TaskResponseDTO> findAll(){
//        List<Task> tasks = taskRepository.findAll();
//        List<TaskResponseDTO> dtos = new ArrayList<>();
//        for (Task task : tasks) {
//            TaskResponseDTO dto = converter.toDto(task);
//            dtos.add(dto);
//        }
//
//        return dtos;

        return taskRepository.findAll().stream()
                .map(converter::toDto)
                .toList();
    }

    public TaskResponseDTO findById(Integer id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task with id = " + id + " not found"));
        return converter.toDto(task);
    }

    // получить список задач по имени менеджера

    public List<TaskResponseDTO> findTasksByManagerName(String managerName) {

        Manager manager = managerService.findByManagerNameForCreateTask(managerName);

        return taskRepository.findByManager(manager).stream()
                .map(converter::toDto)
                .toList();

    }

    public TaskCreateOrUpdateResponseDTO createTask(TaskCreateRequestDTO request) {

        Manager manager = managerService.findByManagerNameForCreateTask(request.getManagerName());
        Task newTask = converter.fromCreateRequest(request);
        newTask.setManager(manager);
        newTask.setCreateDate(LocalDateTime.now());
        newTask.setLastUpdate(LocalDateTime.now());
        newTask.setStatus(TaskStatus.OPEN);
        return converter.toCreateDto(taskRepository.save(newTask));

    }

}
