package com.syriansoldier.big_event.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UpdateUserInfoDto {
    @NotNull
    private Long id;

    @Size(min = 5, max = 16)
    private String username;

    @Size(min = 1, max = 10)
    @NotNull
    private String nickname;

    @Email
    @NotEmpty
    private String email;
}
