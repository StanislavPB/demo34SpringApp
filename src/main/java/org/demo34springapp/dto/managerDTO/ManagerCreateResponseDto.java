package org.demo34springapp.dto.managerDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManagerCreateResponseDto {

    private Integer id;
    private String managerName;
    private String roleName;

}
