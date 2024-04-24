
package org.demo34springapp.service.util;

import org.demo34springapp.dto.managerDTO.ManagerCreateResponseDto;
import org.demo34springapp.dto.taskDto.TaskCreateRequestDto;
import org.demo34springapp.dto.taskDto.TaskCreateResponseDto;
import org.demo34springapp.dto.taskDto.TaskResponseDto;
import org.demo34springapp.entity.Role;
import org.demo34springapp.entity.Task;
import org.springframework.stereotype.Service;

@Service
public class TaskConverter {


    public TaskCreateResponseDto toCreateDTO(Task task) {
        TaskCreateResponseDto response = new TaskCreateResponseDto();

        response.setId(task.getId());
        response.setTaskName(task.getTaskName());
        response.setDescription(task.getDescription());
        response.setDeadline(task.getDeadline());
        response.setStatus(task.getStatus());

        Role managerRole = task.getManager().getRole();

        response.setManager(new ManagerCreateResponseDto(
                task.getId(),
                task.getManager().getManagerName(),
                managerRole.getName()
        ));

        return response;

    }

    public TaskResponseDto toDto(Task task) {
        TaskResponseDto response = new TaskResponseDto();

        response.setId(task.getId());
        response.setTaskName(task.getTaskName());
        response.setDescription(task.getDescription());
        response.setCreateDate(task.getCreateDate());
        response.setLastUpdate(task.getLastUpdate());
        response.setDeadline(task.getDeadline());
        response.setStatus(task.getStatus());

        return response;

    }

    public Task fromCreateRequest(TaskCreateRequestDto request) {
        Task task = new Task();
        task.setTaskName(request.getTaskName());
        task.setDescription(request.getDescription());
        task.setDeadline(request.getDeadline());

        return task;
    }


}
