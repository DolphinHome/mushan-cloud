package com.mushan.common.security.handler;



import com.mushan.exception.AuthException;
import com.mushan.exception.CodeException;
import com.mushan.exception.TokenTimeOutException;
import com.mushan.exception.UserNamePassWordException;
import com.mushan.utlis.R;
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
        e.printStackTrace();
        return R.unauthz();
    }

    @ExceptionHandler(value = UserNamePassWordException.class)
    public Object UserNamePassWordException(Exception e, HttpServletRequest request)
    {
        e.printStackTrace();
        return R.username();
    }

    @ExceptionHandler(value = TokenTimeOutException.class)
    public Object timeException(Exception e, HttpServletRequest request)
    {   //token 过期
        e.printStackTrace();
        return R.unlogin();
    }

    @ExceptionHandler(value = Exception.class)
    public Object e(Exception e, HttpServletRequest request)
    {
        e.printStackTrace();
        return R.fail(-1,e.getMessage());
    }


    @ExceptionHandler(value = CodeException.class)
    public Object CodeException(Exception e, HttpServletRequest request)
    {
        e.printStackTrace();
        return R.captcha();
    }


}
