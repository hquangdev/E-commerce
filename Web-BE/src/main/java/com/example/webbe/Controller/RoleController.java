package com.example.webbe.Controller;

import com.example.webbe.DTO.Request.RoleRequest;
import com.example.webbe.DTO.Response.RoleResponse;
import com.example.webbe.DTO.ResponseDto;
import com.example.webbe.Service.RoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@AllArgsConstructor
@Slf4j
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public ResponseDto<RoleResponse> addRole(@RequestBody RoleRequest roleRequest){
        return ResponseDto.<RoleResponse>builder()
                .data(roleService.addRole(roleRequest))
                .build();
    }

    @GetMapping
    public ResponseDto<List<RoleResponse>> listPermission(){
        return ResponseDto.<List<RoleResponse>>builder()
                .data(roleService.getAll())
                .build();

    }

//    @DeleteMapping("/{id}")
//    public ResponseDto<Void> delete(@PathVariable String id){
//        roleService.deleteRole(id);
//        return ResponseDto.<Void>builder().build();
//    }
}
