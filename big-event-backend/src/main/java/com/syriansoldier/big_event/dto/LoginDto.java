package com.syriansoldier.big_event.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class LoginDto {
    @NotNull(message = "用户名不能为空")
    @Size(min = 5, max = 16, message = "用户名应为5-16位")
    private String username;

    @NotNull(message = "密码不能为空")
    @Size(min = 5, max = 16, message = "密码应为5-16位")
    private String password;
}
