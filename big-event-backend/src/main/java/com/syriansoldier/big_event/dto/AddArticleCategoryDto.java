package com.syriansoldier.big_event.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class AddArticleCategoryDto {
  @NotBlank(message = "分类名称不能为空")
  private String categoryName;

  @NotBlank(message = "分类别名不能为空")
  private String categoryAlias;
}
