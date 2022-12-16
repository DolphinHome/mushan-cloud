package com.mushan.system.service;

import java.util.List;
import com.mushan.system.pojo.SysUserRole;


public interface SysUserRoleService
{


    public List<SysUserRole>List(SysUserRole sysUserRole);

    public SysUserRole query(Long id);

    public int add(SysUserRole sysUserRole);

    public int edit(SysUserRole sysUserRole);

    public int delete(Long id);

}
