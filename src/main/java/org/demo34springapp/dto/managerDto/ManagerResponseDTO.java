package org.demo34springapp.dto.managerDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.demo34springapp.domain.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerResponseDTO {

    private Integer id;
    private String managerName;
    private String email;
    private Role role;
}
