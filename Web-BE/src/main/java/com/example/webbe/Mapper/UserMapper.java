package com.example.webbe.Mapper;

import com.example.webbe.DTO.user.UserRequest;
import com.example.webbe.DTO.user.UserResponse;
import com.example.webbe.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "roles", ignore = true)
    User toUser(UserRequest userRequest);

    UserResponse toUserResponse(User user);

}
