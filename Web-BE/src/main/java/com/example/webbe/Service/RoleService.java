package com.example.webbe.Service;

import com.example.webbe.DTO.Request.RoleRequest;
import com.example.webbe.DTO.Response.RoleResponse;
import com.example.webbe.Mapper.RoleMapper;
import com.example.webbe.Repository.PermissionRepository;
import com.example.webbe.Repository.RoleRepository;
import com.example.webbe.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
private final RoleMapper roleMapper;
    private final PermissionRepository permissionRepository;
    private final UserRepo userRepo;

    public RoleResponse addRole(RoleRequest roleRequest){
        var role = roleMapper.toRole(roleRequest);
        var permissions = permissionRepository.findAllById(roleRequest.getPermission());
        role.setPermission(new HashSet<>(permissions));
        role = roleRepository.save(role);

        return  roleMapper.toRoleResponse(role);
    }

    public List<RoleResponse> getAll(){
        return roleRepository.findAll().stream().map(roleMapper::toRoleResponse).toList();
    }


}
