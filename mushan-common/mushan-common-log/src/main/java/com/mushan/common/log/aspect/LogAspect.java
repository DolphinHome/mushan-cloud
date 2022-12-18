package com.mushan.common.log.aspect;

import com.mushan.common.log.annotation.Log;



import com.mushan.common.security.utils.GetLoginUser;
import com.mushan.pojo.MushanLog;
import com.mushan.utlis.LoginUser;
import com.mushan.utlis.RequestUtlis;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

@Aspect
public class LogAspect {



    @AfterReturning(pointcut = "@annotation(controllerLog)", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Log controllerLog, Object jsonResult)
    {
        handleLog(joinPoint, controllerLog, null, jsonResult);
    }

    @AfterThrowing(value = "@annotation(controllerLog)", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Log controllerLog, Exception e)
    {
        handleLog(joinPoint, controllerLog, e, null);
    }


    protected void handleLog(final JoinPoint joinPoint, Log controllerLog, final Exception e, Object jsonResult){
        HttpServletRequest request = RequestUtlis.getRequest();
        LoginUser user = GetLoginUser.getUser();
        MushanLog log = new MushanLog();
        log.setArgs(Arrays.toString(joinPoint.getArgs()));  // 参数
        log.setUrl(request.getRequestURI());
        log.setMethod(request.getMethod());
        log.setCreateTime(new Date());
        log.setUid(user.getId());
        log.setType(0);
        if (e != null){
            log.setType(1);
            log.setErrMsg(e.getMessage());
        }

    }
}
