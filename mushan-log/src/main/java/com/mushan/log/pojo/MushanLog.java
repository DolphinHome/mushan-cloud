package com.mushan.log.pojo;
import lombok.Data;
import java.util.Date;

@Data
public class MushanLog
{

/**
* 
*/
    private Long id;
/**
* url
*/
    private String url;
/**
* 0 正常  1 异常
*/
    private Integer type;
/**
* 创建时间
*/
    private Date createTime;
/**
* 异常描述
*/
    private String errMsg;
/**
* 用户id
*/
    private Long uid;
/**
* 参数
*/
    private String args;
/**
* 类型
*/
    private String method;



}
