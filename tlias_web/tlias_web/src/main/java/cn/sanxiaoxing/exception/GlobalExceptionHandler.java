package cn.sanxiaoxing.exception;

import cn.sanxiaoxing.dao.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/04/06/22:37
 * @Description: 全局一场处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class) // 捕获全部异常
    public Result ex(Exception exception){
        exception.printStackTrace();
        return Result.error(exception.getMessage());
    }
}
