package com.example.webbe.Mapper;

import com.example.webbe.DTO.Request.PermissionRequest;
import com.example.webbe.DTO.Response.PermissionResponse;
import com.example.webbe.Entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest permissionRequest);

    PermissionResponse toPermissionResponse(Permission permission);

}
