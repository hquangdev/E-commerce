package com.example.webbe.Controller;

import com.example.webbe.DTO.Request.PermissionRequest;
import com.example.webbe.DTO.Response.PermissionResponse;
import com.example.webbe.DTO.ResponseDto;
import com.example.webbe.Service.PermissionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
@AllArgsConstructor
@Slf4j
public class PermissionController {

    private final PermissionService permissionService;

    @PostMapping
    public ResponseDto<PermissionResponse> addPermission(@RequestBody PermissionRequest permissionRequest){
        return ResponseDto.<PermissionResponse>builder()
                .data(permissionService.create(permissionRequest))
                .build();
    }

    @GetMapping
    public ResponseDto<List<PermissionResponse>> listPermission(){
        return ResponseDto.<List<PermissionResponse>>builder()
                .data(permissionService.getAll())
                .build();

    }

    @DeleteMapping("/{id}")
    public ResponseDto<Void> delete(@PathVariable String id){
        permissionService.deletePermission(id);
        return ResponseDto.<Void>builder().build();
    }
}
