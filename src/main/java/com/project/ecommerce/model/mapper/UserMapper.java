package com.project.ecommerce.model.mapper;

import com.project.ecommerce.entity.User;
import com.project.ecommerce.model.dto.UserDto;
import com.project.ecommerce.model.request.CreateUserReq;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.sql.Timestamp;

public class UserMapper {
    public static User toUser(CreateUserReq req) {
        User user = new User();
        user.setFullName(req.getFullName());
        user.setEmail(req.getEmail());
        user.setPassword(BCrypt.hashpw(req.getPassword(), BCrypt.gensalt(12)));
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        user.setStatus(true);
        return user;
    }

    public static UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(userDto.getId());
        userDto.setFullName(user.getFullName());
        userDto.setEmail(user.getEmail());
        userDto.setAddress(user.getAddress());
        userDto.setPhone(user.getPhone());
        userDto.setRoles(user.getRoles());

        return userDto;
    }
}
