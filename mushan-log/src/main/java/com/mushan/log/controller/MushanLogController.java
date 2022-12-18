package com.mushan.log.controller;


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
import com.mushan.log.service.MushanLogService;
import com.mushan.log.pojo.MushanLog;
import java.util.List;

@RestController
@RequestMapping("/mushanLog")
public class MushanLogController
{
    @Autowired
    private MushanLogService mushanLogService;

    /**
    * 查询列表
* @return
*/
    @RequiresPermissions("log:mushanLog:list")
    @GetMapping("/list")
    @Log()
    public Object list(MushanLog mushanLog)
    {
        PageUtils.start();
        List<MushanLog> list = mushanLogService.List(mushanLog);
        return R.table(list);
    }


    /**
    * 通过id 查询
* @return
*/
    @RequiresPermissions("log:mushanLog:query")
    @GetMapping(value = "/{id}")
    @Log()
    public Object query(@PathVariable("id") Long id)
    {
        return R.ok(mushanLogService.query(id));
    }

    /**
     * 新增
     */

    @PostMapping
    public Object add(@RequestBody MushanLog mushanLog)
    {
        return R.ok(mushanLogService.add(mushanLog));
    }

    /**
     * 修改
     */
    @RequiresPermissions("log:mushanLog:edit")
    @PutMapping
    @Log()
    public Object edit(@RequestBody MushanLog mushanLog)
    {
        return R.ok(mushanLogService.edit(mushanLog));
    }

    /**
     * 删除
     */
    @RequiresPermissions("log:mushanLog:remove")
	@DeleteMapping("/{id}")
    @Log()
    public Object delete(@PathVariable("id") Long id)
    {
        return R.ok(mushanLogService.delete(id));
    }
}
