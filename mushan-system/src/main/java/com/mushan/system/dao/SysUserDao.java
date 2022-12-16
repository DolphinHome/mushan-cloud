package com.mushan.system.dao;

import java.util.List;
import com.mushan.system.pojo.SysUser;
import com.mushan.utlis.LoginUser;


public interface SysUserDao
{


    public List<SysUser> list(SysUser sysUser);

    public SysUser query(Long id);

    public int add(SysUser sysUser);

    public int edit(SysUser sysUser);

    public int delete(Long id);

    LoginUser loadUserByUsername(String name);

    List<String> getPower(Long id);
}
