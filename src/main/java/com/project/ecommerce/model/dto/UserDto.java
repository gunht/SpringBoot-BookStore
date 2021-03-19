package com.project.ecommerce.model.dto;

import com.project.ecommerce.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private long id;

    private String username;

    private String email;

    private String fullName;

    private String phone;

    private String address;

    private List<Role> roles = new ArrayList<>();
}
