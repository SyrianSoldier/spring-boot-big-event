package com.syriansoldier.big_event.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UpdatePwdDto {
  @NotNull(message = "旧密码不能为空")
  @Size(min = 5, max = 16, message = "密码长度为6-18位")
  private String old_pwd;

  @NotNull(message = "新密码不能为空")
  @Size(min = 5, max = 16, message = "密码长度为6-18位")
  private String new_pwd;

  @Size(min = 5, max = 16, message = "密码长度为6-18位")
  @NotNull(message = "确认密码不能为空")
  private String re_pwd;
}
