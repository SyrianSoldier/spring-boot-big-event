package com.syriansoldier.big_event.service;

import com.github.pagehelper.Page;
import com.syriansoldier.big_event.dto.ArticleDto;
import com.syriansoldier.big_event.pojo.Article;

public interface ArticleService {

  void add(ArticleDto body);

  void delete(Integer id);

  Article detail(Integer id);

  void update(Integer id, ArticleDto body);

  Page<Article> list(Integer pageNum, Integer pageSize, Integer catId,
      Integer articleStatus);

}
