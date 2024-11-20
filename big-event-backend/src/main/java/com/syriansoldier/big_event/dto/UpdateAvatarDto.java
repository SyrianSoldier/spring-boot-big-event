package com.syriansoldier.big_event.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import lombok.Data;

@Data
public class UpdateAvatarDto {
  @NotBlank(message = "头像链接不能为空")
  @URL(message = "头像链接格式不正确")
  private String avatarUrl;
}
