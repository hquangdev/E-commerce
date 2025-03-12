package com.example.webbe.Mapper;

import com.example.webbe.DTO.Request.RoleRequest;
import com.example.webbe.DTO.Response.RoleResponse;
import com.example.webbe.Entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

//    @Mapping(target = "permission", ignore = true)
    Role toRole(RoleRequest roleRequest);

    RoleResponse toRoleResponse(Role role);

}
