package com.syriansoldier.big_event.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.syriansoldier.big_event.utils.Result;

import java.io.File;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UploadController {
  @PostMapping("/upload")
  public Result<?> upload(@RequestParam("file") MultipartFile file) {
    // 获取文件名
    // String filename = UUID.randomUUID().toString() + '-' +
    // file.getOriginalFilename();

    // 将文件转存到指定路径
    // file.transferTo(new File("D:\\big-event\\big-event-backend\\" +
    // file.getOriginalFilename()));

    return Result.success("上传成功", "http://www.baidu.com/img/flexible/logo/pc/result.png");
  }

  @PostMapping("/test")
  public String test(@RequestBody byte[] file) throws Exception {

    return file.toString() + file.length;
  }

}
