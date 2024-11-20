package com.syriansoldier.big_event.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syriansoldier.big_event.dto.AddArticleCategoryDto;
import com.syriansoldier.big_event.mapper.ArticleCategoryMapper;
import com.syriansoldier.big_event.service.ArticleCategoryService;

@Service
public class ArticleCategoryServiceImpl implements ArticleCategoryService {
  @Autowired
  private ArticleCategoryMapper articleCategoryMapper;

  @Override
  public void add(AddArticleCategoryDto body, Integer userId) {
    articleCategoryMapper.add(body, userId);
  }

}
