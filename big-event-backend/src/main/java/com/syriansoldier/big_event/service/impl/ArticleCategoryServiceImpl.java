package com.syriansoldier.big_event.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syriansoldier.big_event.dto.ArticleCategoryDto;
import com.syriansoldier.big_event.mapper.ArticleCategoryMapper;
import com.syriansoldier.big_event.pojo.ArticleCategory;
import com.syriansoldier.big_event.service.ArticleCategoryService;
import com.syriansoldier.big_event.utils.ThreadLocalUtils;

@Service
public class ArticleCategoryServiceImpl implements ArticleCategoryService {
  @Autowired
  private ArticleCategoryMapper articleCategoryMapper;

  @Override
  public void add(ArticleCategoryDto body, Integer userId) {
    articleCategoryMapper.add(body, userId);
  }

  @Override
  public List<ArticleCategory> list() {
    Map<String, Object> map = ThreadLocalUtils.get();
    Integer userId = (Integer) map.get("userId");

    return articleCategoryMapper.list(userId);
  }

  @Override
  public ArticleCategory detail(Integer id) {
    return articleCategoryMapper.detail(id);
  }

  @Override
  public void delete(Integer id) {
    articleCategoryMapper.delete(id);
  }

  @Override
  public void update(ArticleCategoryDto body) {
    articleCategoryMapper.update(body);
  }

}
