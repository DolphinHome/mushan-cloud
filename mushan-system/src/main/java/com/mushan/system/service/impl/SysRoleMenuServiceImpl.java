package com.mushan.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  com.mushan.system.dao.SysRoleMenuDao;
import com.mushan.system.pojo.SysRoleMenu;
import com.mushan.system.service.SysRoleMenuService;


@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService
{
    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;

    @Override
    public List<SysRoleMenu>List(SysRoleMenu sysRoleMenu){
        return  sysRoleMenuDao.list(sysRoleMenu);
    }

    @Override
    public SysRoleMenu query(Long id){
        return sysRoleMenuDao.query(id);
    }

    @Override
    public int add(SysRoleMenu sysRoleMenu){
       return sysRoleMenuDao.add(sysRoleMenu);
    }

    @Override
    public int edit(SysRoleMenu sysRoleMenu){
        return sysRoleMenuDao.edit(sysRoleMenu);
    }

    @Override
    public int delete(Long id){
        return sysRoleMenuDao.delete(id);
    }

}
