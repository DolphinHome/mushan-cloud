package com.mushan.system.service;

import java.util.List;
import com.mushan.system.pojo.SysRoleMenu;


public interface SysRoleMenuService
{


    public List<SysRoleMenu>List(SysRoleMenu sysRoleMenu);

    public SysRoleMenu query(Long id);

    public int add(SysRoleMenu sysRoleMenu);

    public int edit(SysRoleMenu sysRoleMenu);

    public int delete(Long id);

}
