package com.mushan.common.security.handler;



import com.mushan.exception.AuthException;
import com.mushan.utlis.ResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理器
 * 

 */
@RestControllerAdvice
public class GlobalExceptionHandler
{

    @ExceptionHandler(value = AuthException.class)
    public Object handleNotPermissionException(Exception e, HttpServletRequest request)
    {
        return ResponseUtils.unauthz();
    }

    @ExceptionHandler(value = Exception.class)
    public Object e(Exception e, HttpServletRequest request)
    {
        return ResponseUtils.fail(-1,e.getMessage());
    }

}
