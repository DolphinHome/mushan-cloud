package com.mushan.system.service.impl;

import java.util.List;
import java.util.Map;

import com.mushan.system.dao.SysUserRoleDao;
import com.mushan.system.pojo.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import  com.mushan.system.dao.SysUserDao;
import com.mushan.system.pojo.SysUser;
import com.mushan.system.service.SysUserService;


@Service
public class SysUserServiceImpl implements SysUserService
{
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;

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
        //添加 用户表
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        sysUserDao.add(sysUser);
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(sysUser.getId());
        sysUserRole.setRoleId(sysUser.getRole());
        //添加用户角色表
       return sysUserRoleDao.add(sysUserRole);
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
