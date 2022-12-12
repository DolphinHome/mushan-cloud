package com.mushan.common.security.handler;



import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理器
 * 

 */
@RestControllerAdvice
public class GlobalExceptionHandler
{

    @ExceptionHandler(value = Exception.class)
    public Object handleNotPermissionException(Exception e, HttpServletRequest request)
    {
        return "异常了";
    }

}
