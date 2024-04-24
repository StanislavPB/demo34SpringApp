package org.demo34springapp.dto.auth;

import lombok.Data;

@Data
public class AuthRequest {

    private String managerName;
    private String password;
}
