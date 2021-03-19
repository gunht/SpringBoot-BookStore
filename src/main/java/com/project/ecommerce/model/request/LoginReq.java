package com.project.ecommerce.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginReq {
    @NotNull(message = "Email trống")
    @NotEmpty(message = "Email trống")
    @Email(message = "Email không đúng định dạng")
    @ApiModelProperty(
            example = "Victor.vangos@gmail.com",
            notes = "Email trống",
            required = true
    )
    private String email;

    @NotNull(message = "Mật khẩu trống")
    @NotEmpty(message = "Mật khẩu trống")
    @Size(min = 4, max = 30, message = "Mật khẩu phải dài từ 4 - 30 ký tự")
    @ApiModelProperty(
            example = "matkhaungaunhien",
            notes = "Mật khẩu trống",
            required = true
    )
    private String password;
}
