package com.mushan.system.dao;

import java.util.List;
import com.mushan.system.pojo.SysUserRole;


public interface SysUserRoleDao
{


    public List<SysUserRole> list(SysUserRole sysUserRole);

    public SysUserRole query(Long id);

    public int add(SysUserRole sysUserRole);

    public int edit(SysUserRole sysUserRole);

    public int delete(Long id);

}
