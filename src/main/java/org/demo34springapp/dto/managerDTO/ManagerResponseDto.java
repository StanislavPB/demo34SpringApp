package org.demo34springapp.dto.managerDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.demo34springapp.entity.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManagerResponseDto {
    private Integer id;
    private String managerName;
    private String email;
    private Role role;
}
