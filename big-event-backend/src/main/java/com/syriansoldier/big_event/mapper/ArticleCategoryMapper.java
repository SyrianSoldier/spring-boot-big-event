package com.syriansoldier.big_event.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.syriansoldier.big_event.dto.ArticleCategoryDto;
import com.syriansoldier.big_event.pojo.ArticleCategory;

@Mapper
public interface ArticleCategoryMapper {
  void add(@Param("body") ArticleCategoryDto body, @Param("userid") Integer userid);

  List<ArticleCategory> list(@Param("createUserId") Integer createUserId);

  ArticleCategory detail(@Param("id") Integer id);

  void delete(@Param("id") Integer id);

  void update(@Param("body") ArticleCategoryDto body);
}
