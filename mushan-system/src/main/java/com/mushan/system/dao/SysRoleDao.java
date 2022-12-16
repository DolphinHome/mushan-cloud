package com.mushan.system.dao;

import java.util.List;
import java.util.Map;

import com.mushan.system.pojo.SysRole;


public interface SysRoleDao
{


    public List<SysRole> list(SysRole sysRole);

    public SysRole query(Long id);

    public int add(SysRole sysRole);

    public int edit(SysRole sysRole);

    public int delete(Long id);

    List<Map<String, Object>> roles();
}
