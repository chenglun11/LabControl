package com.lchnan7.modules.exception;

import com.lchnan7.modules.utils.Result;
import com.lchnan7.modules.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局处理异常
 */
@Slf4j
@RestControllerAdvice //进行统一异常处理
public class GlobalExceptionHandler {

    //实体类检验异常
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handler(MethodArgumentNotValidException e){

        BindingResult bindingResult = e.getBindingResult();
        ObjectError objectError = bindingResult.getAllErrors().stream().findFirst().get();

        log.error("实体校验异常-------{}",objectError.getDefaultMessage());
//        return ResultUtil.error(-1,e.getMessage());
        return ResultUtil.error(-1,e.getMessage());
    }


    //运行异常
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public Result handler(RuntimeException e){
        System.out.println(e);
        log.error("run运行异常-------{}",e.getMessage());
        return ResultUtil.error(-1,"服务器开小差了");
    }


    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    public Result exceptionHandler(HttpServletRequest req, NullPointerException e){
        log.error("发生空指针异常！原因是:",e);
        return ResultUtil.error(-1,"服务器开小差了");
    }


    //形参异常
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public Result handler(IllegalArgumentException e){
        log.error("Assert异常-------{}",e.getMessage());
        return ResultUtil.error(-1,"服务器开小差了");
    }
}
