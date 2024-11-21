package com.syriansoldier.big_event.service;

import java.util.List;

import com.syriansoldier.big_event.dto.ArticleCategoryDto;
import com.syriansoldier.big_event.pojo.ArticleCategory;

public interface ArticleCategoryService {
  void add(ArticleCategoryDto body, Integer userId);

  List<ArticleCategory> list();

  ArticleCategory detail(Integer id);

  void delete(Integer id);

  void update(ArticleCategoryDto body);

}
