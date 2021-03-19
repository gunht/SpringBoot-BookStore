package com.project.ecommerce.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserReq {
    private String username;
    private String password;
    private String fullName;
    private String email;
}
