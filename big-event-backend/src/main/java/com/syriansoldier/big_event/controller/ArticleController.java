package com.syriansoldier.big_event.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.syriansoldier.big_event.anno.State;
import com.syriansoldier.big_event.dto.ArticleDto;
import com.syriansoldier.big_event.pojo.Article;
import com.syriansoldier.big_event.service.ArticleService;
import com.syriansoldier.big_event.utils.PageList;
import com.syriansoldier.big_event.utils.Result;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@Validated
@RequestMapping("/article")
public class ArticleController {
  @Autowired
  private ArticleService articleService;

  @PostMapping
  public Result<?> add(@Validated(ArticleDto.Add.class) @RequestBody ArticleDto body) {
    articleService.add(body);
    return Result.success("新增文章成功", null);
  }

  @DeleteMapping("/{id}")
  public Result<?> delete(@NotNull @PathVariable("id") Integer id) {
    articleService.delete(id);
    return Result.success("删除文章成功", null);
  }

  @GetMapping("/{id}")
  public Result<Article> detail(@PathVariable("id") Integer id) {
    return Result.success("查询文章成功", articleService.detail(id));
  }

  @PutMapping("/{id}")
  public Result<?> update(@NotNull @PathVariable Integer id,
      @Validated(ArticleDto.Update.class) @RequestBody ArticleDto body) {
    articleService.update(id, body);
    return Result.success("更新文章成功", null);
  }

  @GetMapping
  public Result<PageList<Article>> list(
      @NotNull @Min(1) @RequestParam("pageNum") Integer pageNum,
      @NotNull @Min(1) @Max(100) @RequestParam("pageSize") Integer pageSize,
      @RequestParam(value = "catId", required = false) Integer catId,
      @State @RequestParam(value = "articleStatus", required = false) Integer articleStatus) {

    return Result.success("查询文章列表成功", new PageList<>(articleService.list(pageNum, pageSize, catId, articleStatus)));
  }

}
