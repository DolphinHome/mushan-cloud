package com.mushan.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  com.mushan.system.dao.SysUserDao;
import com.mushan.system.pojo.SysUser;
import com.mushan.system.service.SysUserService;


@Service
public class SysUserServiceImpl implements SysUserService
{
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public List<SysUser>List(SysUser sysUser){
        return  sysUserDao.list(sysUser);
    }

    @Override
    public SysUser query(Long id){
        return sysUserDao.query(id);
    }

    @Override
    public int add(SysUser sysUser){
       return sysUserDao.add(sysUser);
    }

    @Override
    public int edit(SysUser sysUser){
        return sysUserDao.edit(sysUser);
    }

    @Override
    public int delete(Long id){
        return sysUserDao.delete(id);
    }

}
