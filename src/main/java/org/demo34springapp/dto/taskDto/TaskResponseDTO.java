package org.demo34springapp.dto.taskDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.demo34springapp.domain.TaskStatus;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDTO {
    private Integer id;
    private String taskName;
    private String description;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
    private LocalDateTime deadline;
    private TaskStatus status;
}
