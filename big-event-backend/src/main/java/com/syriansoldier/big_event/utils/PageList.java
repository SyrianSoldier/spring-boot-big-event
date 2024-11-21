package com.syriansoldier.big_event.utils;

import java.util.List;

import com.github.pagehelper.Page;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageList<T> {
  private Long totol;
  private List<T> list;

  public PageList(Page<T> page) {
    this.totol = page.getTotal();
    this.list = page.getResult();
  }
}
