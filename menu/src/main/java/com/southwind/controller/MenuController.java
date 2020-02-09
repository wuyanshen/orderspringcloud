package com.southwind.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.southwind.common.Result;
import com.southwind.entity.TMenu;
import com.southwind.entity.TType;
import com.southwind.service.TMenuService;
import com.southwind.service.TTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wuyanshen
 * @date 2020-02-07 4:48 下午
 * @discription 控制器
 */
@RestController
@RequestMapping("menu")
public class MenuController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private TMenuService tMenuService;

    @Autowired
    private TTypeService tTypeService;

    @GetMapping("index")
    public String index(){
        return "menu的端口是："+ this.port;
    }

    @GetMapping("findAll")
    public Result<List<TMenu>> findAll(long current,long size){
        Page page = new Page();
        page.setCurrent(current);
        page.setSize(size);
        IPage iPage = tMenuService.findAll(page);
        return new Result(0,"成功", (int)iPage.getTotal(), iPage.getRecords());
    }

    @DeleteMapping("delete/{id}")
    public Result delete(@PathVariable("id") long id){
        return new Result(0,"成功", 1, tMenuService.removeById(id));
    }

    @GetMapping("findTypes")
    public List<TType> findTypes(){
        return tTypeService.list();
    }

    @GetMapping("findById/{id}")
    public TMenu getById(@PathVariable("id") long id){
        return tMenuService.findMenuBydId(id);
//        return new Result(0,"成功",1,tMenuService.getById(id));
    }

    @PostMapping("add")
    public Result add(@RequestBody TMenu tMenu){
        return new Result(0,"成功",1,tMenuService.saveMenu(tMenu));
    }

    @PostMapping("update")
    public Result update(@RequestBody TMenu tMenu){
        return new Result(0,"成功",1,tMenuService.updateMenu(tMenu));
    }
}
