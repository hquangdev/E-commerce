package com.example.webbe.Controller;

import com.example.webbe.DTO.ResponseDto;
import com.example.webbe.DTO.user.UserRequest;
import com.example.webbe.DTO.user.UserResponse;
import com.example.webbe.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Slf4j
public class UserController {
     private final UserService userService;

    @PostMapping
    public ResponseEntity<ResponseDto<Object>> registerUser(@Valid @RequestBody UserRequest userRequest) {
        return userService.registerUser(userRequest);
    }

    @PostMapping("/{id}")
    public ResponseDto<UserResponse> updateUser(@Valid @PathVariable("id") String id, @RequestBody UserRequest userRequest){
        System.out.println("id là: " + id);
        ResponseDto<UserResponse> responseDto = new ResponseDto<>();

        responseDto.setData(userService.updateUser(id, userRequest));
        return responseDto;
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUser(){
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("Username: {}", authentication.getName());

        authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable("id") String id){
        System.out.println("ID nhận được: " + id);
        return userService.getUser(id);
    }

}
