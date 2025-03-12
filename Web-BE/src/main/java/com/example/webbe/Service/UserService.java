package com.example.webbe.Service;

import com.example.webbe.DTO.ResponseDto;
import com.example.webbe.DTO.user.UserRequest;
import com.example.webbe.DTO.user.UserResponse;
import com.example.webbe.Entity.Role;
import com.example.webbe.Entity.User;
import com.example.webbe.Mapper.UserMapper;
import com.example.webbe.Repository.RoleRepository;
import com.example.webbe.Repository.UserRepo;
import com.example.webbe.exception.AppException;
import com.example.webbe.exception.EnumCode;
import com.example.webbe.exception.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {
    private final RoleRepository roleRepository;
    private final UserRepo userRepo;

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public ResponseEntity<ResponseDto<Object>> registerUser(UserRequest userRequest) {
        if (userRepo.existsByName(userRequest.getName())) {
            throw new AppException(EnumCode.USER_FAILED_NAME);
        }
        try{
            User user = userMapper.toUser(userRequest);

            user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

            Role userRole = new Role();
            userRole.setName("USER");

            Set<Role> roles = new HashSet<>();
            roles.add(userRole);
            user.setRoles(roles);

            UserResponse response = userMapper.toUserResponse(userRepo.save(user));

            return ResponseBuilder.okResponse(
                    EnumCode.REGISTER_SUCC,
                    response
            );
        }catch (Exception e){
            return ResponseBuilder.failedResponse(
                    EnumCode.REGISTER_FAILED
            );
        }

    }

    //cập nhật user
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserResponse updateUser(String id, UserRequest userRequest){
        User user = userRepo.findById(id)
                .orElseThrow(()-> new AppException(EnumCode.USER_NOT_EXITED));

        user.setName(userRequest.getName());
        user.setAddress(userRequest.getAddress());
        user.setPhone(userRequest.getPhone());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        var roles = roleRepository.findAllById(userRequest.getRoles());
        user.setRoles(new HashSet<>(roles));

        return userMapper.toUserResponse(userRepo.save(user));

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UserResponse> getAllUser(){
        log.info("In Method get User");
        return userRepo.findAll().stream().map(userMapper::toUserResponse).toList();
    }


    @PreAuthorize("hasAuthority('DELETE-USER')")
    public UserResponse getUser(String id) {
        return userMapper.toUserResponse(userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy id")));
    }
}
