package org.demo34springapp.dto.managerDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerCreateRequestDto {

    private String managerName;
    private String password;
    private String email;

}
