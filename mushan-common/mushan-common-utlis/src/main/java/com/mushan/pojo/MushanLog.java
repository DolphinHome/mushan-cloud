package com.mushan.pojo;


import java.util.Date;


public class MushanLog
{
    @Override
    public String toString() {
        return "MushanLog{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", type=" + type +
                ", createTime=" + createTime +
                ", errMsg='" + errMsg + '\'' +
                ", uid=" + uid +
                ", args='" + args + '\'' +
                ", method='" + method + '\'' +
                '}';
    }

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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
