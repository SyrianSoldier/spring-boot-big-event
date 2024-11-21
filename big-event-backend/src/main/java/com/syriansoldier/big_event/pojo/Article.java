package com.syriansoldier.big_event.pojo;

import lombok.Data;

/**
 * Request
 */
@Data
public class Article {
  /**
   * 文章内容
   */
  private String articleContent;
  /**
   * 文章封面
   */
  private String articleCover;
  /**
   * 文章状态, 0:草稿, 1:已发布
   */
  private long articleStatus;
  /**
   * 文章标题
   */
  private String articleTitle;
  /**
   * 文章分类id, 外键
   */
  private long catId;
  /**
   * 创建时间, 文章发表时间
   */
  private String createdTime;
  /**
   * 创建人id, 外键
   */
  private long createdUser;
  /**
   * 文章id
   */
  private long id;
  /**
   * 更新时间
   */
  private String updatedTime;
}
