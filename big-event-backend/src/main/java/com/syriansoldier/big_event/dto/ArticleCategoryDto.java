package com.syriansoldier.big_event.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import lombok.Data;

@Data
public class ArticleCategoryDto {
  @NotBlank(message = "分类名称不能为空")
  private String categoryName;

  @NotBlank(message = "分类别名不能为空")
  private String categoryAlias;

  @NotNull(message = "分类id不能为空", groups = Update.class)
  private Integer id;

  public interface Add extends Default {
  }

  public interface Update extends Default {
  }
}
