package com.syriansoldier.big_event.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syriansoldier.big_event.dto.AddArticleCategoryDto;
import com.syriansoldier.big_event.service.ArticleCategoryService;
import com.syriansoldier.big_event.utils.Result;
import com.syriansoldier.big_event.utils.ThreadLocalUtils;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/category")
public class AriticleCategory {
  @Autowired
  ArticleCategoryService articleCategoryService;

  @PostMapping
  public Result<?> postMethodName(@RequestBody AddArticleCategoryDto body) {
    Map<String, Object> map = ThreadLocalUtils.get();

    articleCategoryService.add(body, (Integer) map.get("userId"));

    return Result.success("新增文章成功", null);
  }

}
