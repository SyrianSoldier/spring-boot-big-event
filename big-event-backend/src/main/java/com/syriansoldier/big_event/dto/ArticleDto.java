package com.syriansoldier.big_event.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import org.hibernate.validator.constraints.URL;

import com.syriansoldier.big_event.anno.State;

import lombok.Data;

@Data
public class ArticleDto {
  @NotBlank(message = "文章标题不能为空", groups = { Add.class })
  private String articleContent;

  @URL(message = "文章封面图片地址格式不正确", groups = { Add.class, Update.class })
  @NotBlank(message = "文章封面不能为空", groups = { Add.class })
  private String articleCover;

  @State(message = "文章状态只能为0或者1", groups = { Add.class, Update.class })
  @NotNull(message = "文章状态不能为空", groups = { Add.class })
  private Integer articleStatus;

  @NotBlank(message = "文章内容不能为空", groups = { Add.class })
  private String articleTitle;

  @NotNull(message = "文章分类不能为空", groups = { Add.class })
  private Integer catId;

  public interface Add extends Default {

  }

  public interface Update extends Default {

  }

}
