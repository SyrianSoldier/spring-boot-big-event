package com.syriansoldier.big_event.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syriansoldier.big_event.dto.ArticleCategoryDto;
import com.syriansoldier.big_event.pojo.ArticleCategory;
import com.syriansoldier.big_event.service.ArticleCategoryService;
import com.syriansoldier.big_event.utils.Result;
import com.syriansoldier.big_event.utils.ThreadLocalUtils;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@Validated
@RequestMapping("/category")
public class AriticleCategoryController {
  @Autowired
  ArticleCategoryService articleCategoryService;

  @PostMapping
  public Result<?> add(@Validated(ArticleCategoryDto.Add.class) @RequestBody ArticleCategoryDto body) {
    Map<String, Object> map = ThreadLocalUtils.get();

    articleCategoryService.add(body, (Integer) map.get("userId"));

    return Result.success("新增文章成功", null);
  }

  @GetMapping
  public Result<List<ArticleCategory>> list() {
    return Result.success("操作成功", articleCategoryService.list());
  }

  @GetMapping("/{id}")
  public ArticleCategory detail(@PathVariable("id") @NotNull(message = "id不能为空") Integer id) {
    return articleCategoryService.detail(id);
  }

  @DeleteMapping("/{id}")
  public Result<?> delete(@PathVariable("id") @NotNull(message = "id不能为空") Integer id) {
    articleCategoryService.delete(id);
    return Result.success("删除文章成功", null);
  }

  @PutMapping
  public Result<?> update(@Validated(ArticleCategoryDto.Update.class) @RequestBody ArticleCategoryDto body) {
    articleCategoryService.update(body);
    return Result.success("更新文章成功", null);
  }
}
