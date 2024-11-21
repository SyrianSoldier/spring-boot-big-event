package com.syriansoldier.big_event.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.syriansoldier.big_event.dto.ArticleDto;
import com.syriansoldier.big_event.mapper.ArticleMapper;
import com.syriansoldier.big_event.pojo.Article;
import com.syriansoldier.big_event.service.ArticleService;
import com.syriansoldier.big_event.utils.ThreadLocalUtils;

@Service
public class ArticleServiceImpl implements ArticleService {
  @Autowired
  private ArticleMapper articleMapper;

  @Override
  public void add(ArticleDto body) {
    Map<String, Object> map = ThreadLocalUtils.get();
    articleMapper.add(body, (Integer) map.get("userId"));
  }

  @Override
  public void delete(Integer id) {
    articleMapper.delete(id);
  }

  @Override
  public Article detail(Integer id) {
    return articleMapper.detail(id);
  }

  @Override
  public void update(Integer id, ArticleDto body) {
    articleMapper.update(id, body);
  }

  @Override
  public Page<Article> list(Integer pageNum, Integer pageSize, Integer catId, Integer articleStatus) {
    PageHelper.startPage(pageNum, pageSize);
    return articleMapper.list(catId, articleStatus);
  }

}
