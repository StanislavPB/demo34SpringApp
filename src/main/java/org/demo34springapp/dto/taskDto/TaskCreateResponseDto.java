package org.demo34springapp.dto.taskDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.demo34springapp.dto.managerDTO.ManagerCreateResponseDto;
import org.demo34springapp.entity.TaskStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreateResponseDto {

    private Integer id;
    private String taskName;
    private String description;
    private LocalDateTime deadline;
    private TaskStatus status;

    private ManagerCreateResponseDto manager;
}
