package com.mushan.system.controller;


import com.mushan.utlis.PageUtils;
import com.mushan.common.log.annotation.Log;
import com.mushan.common.security.annotation.RequiresPermissions;
import com.mushan.utlis.R;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mushan.system.service.SysUserService;
import com.mushan.system.pojo.SysUser;
import java.util.List;

@RestController
    @RequestMapping("/sysUser")
public class SysUserController
{
    @Autowired
    private SysUserService sysUserService;

    /**
    * 查询列表
* @return
*/
    @RequiresPermissions("system:sysUser:list")
        @GetMapping("/list")
    @Log()
    public Object list(SysUser sysUser)
    {
        PageUtils.start();
        List<SysUser> list = sysUserService.List(sysUser);
        return R.table(list);
    }


    /**
    * 通过id 查询
* @return
*/
    @RequiresPermissions("system:sysUser:query")
    @GetMapping(value = "/{id}")
    @Log()
    public Object query(@PathVariable("id") Long id)
    {
        return R.ok(sysUserService.query(id));
    }

    /**
     * 新增
     */
    @RequiresPermissions("system:sysUser:add")
    @PostMapping
    @Log()
    public Object add(@RequestBody SysUser sysUser)
    {
        return R.ok(sysUserService.add(sysUser));
    }

    /**
     * 修改
     */
    @RequiresPermissions("system:sysUser:edit")
    @PutMapping
    @Log()
    public Object edit(@RequestBody SysUser sysUser)
    {
        return R.ok(sysUserService.edit(sysUser));
    }

    /**
     * 删除
     */
    @RequiresPermissions("system:sysUser:remove")
	@DeleteMapping("/{id}")
    @Log()
    public Object delete(@PathVariable("id") Long id)
    {
        return R.ok(sysUserService.delete(id));
    }





}
