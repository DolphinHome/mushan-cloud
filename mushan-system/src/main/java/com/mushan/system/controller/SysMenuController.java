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
import com.mushan.system.service.SysMenuService;
import com.mushan.system.pojo.SysMenu;
import java.util.List;

@RestController
@RequestMapping("/sysMenu")
public class SysMenuController
{
    @Autowired
    private SysMenuService sysMenuService;

    /**
    * 查询列表
* @return
*/
    @RequiresPermissions("system:sysMenu:list")
    @GetMapping("/list")
    @Log()
    public Object list(SysMenu sysMenu)
    {

        List<SysMenu> list = sysMenuService.List(sysMenu);
        return R.ok(list);
    }


    /**
    * 通过id 查询
* @return
*/
    @RequiresPermissions("system:sysMenu:query")
    @GetMapping(value = "/{id}")
    @Log()
    public Object query(@PathVariable("id") Long id)
    {
        return R.ok(sysMenuService.query(id));
    }

    /**
     * 新增
     */
    @RequiresPermissions("system:sysMenu:add")
    @PostMapping
    @Log()
    public Object add(@RequestBody SysMenu sysMenu)
    {
        return R.ok(sysMenuService.add(sysMenu));
    }

    /**
     * 修改
     */
    @RequiresPermissions("system:sysMenu:edit")
    @PutMapping
    @Log()
    public Object edit(@RequestBody SysMenu sysMenu)
    {
        return R.ok(sysMenuService.edit(sysMenu));
    }

    /**
     * 删除
     */
    @RequiresPermissions("system:sysMenu:remove")
	@DeleteMapping("/{id}")
    @Log()
    public Object delete(@PathVariable("id") Long id)
    {
        return R.ok(sysMenuService.delete(id));
    }

    /**
     * 通过用户id 查询路由信息
     */
    @GetMapping("/getRouters")
    @Log()
    public Object getRouters(){
        return R.ok(sysMenuService.getRouters());
    }

}
