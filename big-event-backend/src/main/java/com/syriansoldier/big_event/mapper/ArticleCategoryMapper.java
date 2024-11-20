package com.syriansoldier.big_event.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.syriansoldier.big_event.dto.AddArticleCategoryDto;

@Mapper
public interface ArticleCategoryMapper {
  void add(@Param("body") AddArticleCategoryDto body, @Param("userid") Integer userid);
}
