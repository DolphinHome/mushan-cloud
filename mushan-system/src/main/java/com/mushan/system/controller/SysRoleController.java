package com.mushan.system.controller;


import com.mushan.utlis.PageUtils;
import com.mushan.common.log.annotation.Log;
import com.mushan.common.security.annotation.RequiresPermissions;
import com.mushan.utlis.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mushan.system.service.SysRoleService;
import com.mushan.system.pojo.SysRole;
import java.util.List;

@RestController
@RequestMapping("/sysRole")
public class SysRoleController
{
    @Autowired
    private SysRoleService sysRoleService;

    /**
    * 查询列表
* @return
*/
    @RequiresPermissions("system:sysRole:list")
    @GetMapping("/list")
    @Log()
    public Object list(SysRole sysRole)
    {
        PageUtils.start();
        List<SysRole> list = sysRoleService.List(sysRole);
        return R.table(list);
    }


    /**
    * 通过id 查询
* @return
*/
    @RequiresPermissions("system:sysRole:query")
    @GetMapping(value = "/{id}")
    @Log()
    public Object query(@PathVariable("id") Long id)
    {
        return R.ok(sysRoleService.query(id));
    }

    /**
     * 新增
     */
    @RequiresPermissions("system:sysRole:add")
    @PostMapping
    @Log()
    public Object add(@RequestBody SysRole sysRole)
    {
        return R.ok(sysRoleService.add(sysRole));
    }

    /**
     * 修改
     */
    @RequiresPermissions("system:sysRole:edit")
    @PutMapping
    @Log()
    public Object edit(@RequestBody SysRole sysRole)
    {
        return R.ok(sysRoleService.edit(sysRole));
    }

    /**
     * 删除
     */
    @RequiresPermissions("system:sysRole:remove")
	@DeleteMapping("/{id}")
    @Log()
    public Object delete(@PathVariable("id") Long id)
    {
        return R.ok(sysRoleService.delete(id));
    }


    @GetMapping("/roles")
    @Log()
    public Object roles(){
        return R.ok(sysRoleService.roles());
    }





}
