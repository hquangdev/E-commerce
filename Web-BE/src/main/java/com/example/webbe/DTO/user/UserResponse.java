package com.example.webbe.DTO.user;

import com.example.webbe.DTO.Response.RoleResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private Set<RoleResponse> roles;
}
