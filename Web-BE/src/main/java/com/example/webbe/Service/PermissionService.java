package com.example.webbe.Service;

import com.example.webbe.DTO.Request.PermissionRequest;
import com.example.webbe.DTO.Response.PermissionResponse;
import com.example.webbe.Entity.Permission;
import com.example.webbe.Mapper.PermissionMapper;
import com.example.webbe.Repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PermissionService {

    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    public PermissionResponse create(PermissionRequest permissionRequest){
        Permission permission = permissionMapper.toPermission(permissionRequest);
        permissionRepository.save(permission);

        return permissionMapper.toPermissionResponse(permission);
    }


    public List<PermissionResponse> getAll(){
        var permission = permissionRepository.findAll();
        return permission.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    public void deletePermission(String id){
        permissionRepository.deleteById(id);
    }

}
