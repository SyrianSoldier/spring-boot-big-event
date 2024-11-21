package com.syriansoldier.big_event.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.syriansoldier.big_event.dto.ArticleDto;
import com.syriansoldier.big_event.pojo.Article;

@Mapper
public interface ArticleMapper {
  void add(@Param("body") ArticleDto body, @Param("userId") Integer userId);

  void delete(@Param("id") Integer id);

  Article detail(@Param("id") Integer id);

  void update(@Param("id") Integer id, @Param("body") ArticleDto body);

  Page<Article> list(@Param("catId") Integer catId, @Param("articleStatus") Integer articleStatus);
}
