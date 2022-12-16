package com.mushan.common.security.aspect;


import com.mushan.common.security.annotation.RequiresPermissions;
import com.mushan.exception.AuthException;
import com.mushan.exception.TokenTimeOutException;
import com.mushan.utlis.JwtUtils;
import com.mushan.utlis.LoginUser;
import com.mushan.utlis.RequestUtlis;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Configuration
public class PreAuthorizeAspect {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 构建
     */
    public PreAuthorizeAspect() {
    }
    /**
     * 定义AOP签名 (切入所有使用鉴权注解的方法)
     */
    public static final String POINTCUT_SIGN = " @annotation(com.mushan.common.security.annotation.RequiresPermissions)";

    /**
     * 声明AOP签名
     */
    @Pointcut(POINTCUT_SIGN)
    public void pointcut() {
    }

    /**
     * 环绕切入
     *
     * @param joinPoint 切面对象
     * @return 底层方法执行后的返回值
     * @throws Throwable 底层方法抛出的异常
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 注解鉴权
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        checkMethodAnnotation(signature.getMethod());
        try {
            // 执行原有逻辑
            Object obj = joinPoint.proceed();
            return obj;
        } catch (Throwable e) {

            throw e;
        }
    }


    /**
     * 对一个Method对象进行注解检查
     */
    public void checkMethodAnnotation(Method method) {

        RequiresPermissions requiresPermissions = method.getAnnotation(RequiresPermissions.class);
        if (requiresPermissions != null) {
            doCheckPermissions(requiresPermissions);
        }
    }


    //检查权限 如果没有权限 就抛出异常信息

    private void doCheckPermissions(RequiresPermissions requiresPermissions){
        String value = requiresPermissions.value();  //权限信息
        HttpServletRequest request = RequestUtlis.getRequest();
        String token = request.getHeader("mushan-token");   // 获取token
        if (StringUtils.isEmpty(token)){
            throw new  AuthException();
        }else {
            //解析token
            String uuid = JwtUtils.getUserNameFormToken(token);
            if (redisTemplate.hasKey("user" + uuid)){
                LoginUser loginUser = (LoginUser) redisTemplate.opsForValue().get("user" + uuid);
                if (!loginUser.getAuthorities().contains(value)){
                    throw new  AuthException();
                }
            }else {
                throw new TokenTimeOutException();
            }

        }
    }

}
