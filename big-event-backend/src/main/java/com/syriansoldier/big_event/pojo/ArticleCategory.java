package com.syriansoldier.big_event.pojo;

import lombok.Data;

@Data
public class ArticleCategory {
  private Integer id;
  private String catName;
  private String catAlias;
  private Integer created_user;
  private String createdTime;
  private String updatedTime;
}
