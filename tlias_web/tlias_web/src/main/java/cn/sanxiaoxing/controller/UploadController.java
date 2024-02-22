package cn.sanxiaoxing.controller;

import cn.sanxiaoxing.dao.Result;
import cn.sanxiaoxing.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/02/22/23:20
 * @Description: 上传文件
 */

@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliOSSUtils ossUtils;

    //本地存储的方式
//    @PostMapping("/upload")
//    public Result upload(String username, Integer age , @RequestParam("imqge") MultipartFile file) throws IOException {
//        log.info("文件上传{}，{}，{}", username,age,file);
//
//        //获取原神文件名
//        String originalFilename = file.getOriginalFilename();
//
//        //构造唯一的文件名 - uuid (通用唯一识别码)
//        int index = originalFilename.lastIndexOf(".");
//        String extname = originalFilename.substring(index);
//        String newFileName = UUID.randomUUID().toString() + extname;
//        log.info("文件名：{}", newFileName);
//
//        // 将文件存储在磁盘目录上
//        file.transferTo(new File("D:\\download\\"+newFileName));
//
//        return Result.success();
//    }

    @PostMapping("/upload")
    public Result upload(@RequestParam("image") MultipartFile file) throws IOException {
        log.info("文件上传：{}", file.getOriginalFilename());

        String url = ossUtils.upload(file);
        log.info("url:{}", url);

        return Result.success(url);
    }
}
