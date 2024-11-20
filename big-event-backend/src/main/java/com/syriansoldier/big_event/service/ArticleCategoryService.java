package com.syriansoldier.big_event.service;

import com.syriansoldier.big_event.dto.AddArticleCategoryDto;

public interface ArticleCategoryService {
  void add(AddArticleCategoryDto body, Integer userId);

}
