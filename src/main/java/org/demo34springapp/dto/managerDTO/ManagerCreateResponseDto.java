package org.demo34springapp.dto.managerDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerCreateResponseDto {

    private Integer id;
    private String managerName;
    private String roleName;

}
