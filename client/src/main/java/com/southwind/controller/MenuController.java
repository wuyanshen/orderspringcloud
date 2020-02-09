package com.southwind.controller;

import com.southwind.common.Result;
import com.southwind.entity.TMenu;
import com.southwind.entity.TType;
import com.southwind.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author wuyanshen
 * @date 2020-02-07 11:17 下午
 * @discription 控制器
 */
@Controller
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("findAll")
    @ResponseBody
    public Result<List<TMenu>> findAll(long page,long limit){
        return menuFeign.findAll(page,limit);
    }

    @GetMapping("redirect/{location}")
    public String redirect(@PathVariable("location") String location){
       return location;
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") long id){
        menuFeign.delete(id);
        return "redirect:/menu/redirect/index";
    }

    @GetMapping("findTypes")
    public ModelAndView findAll(ModelAndView modelAndView){
        modelAndView.setViewName("menu_update");
        modelAndView.addObject("list" ,menuFeign.findTypes());
        return modelAndView;
    }

    @GetMapping("preAdd")
    public ModelAndView preAdd(ModelAndView modelAndView){
        modelAndView.setViewName("menu_add");
        modelAndView.addObject("list" ,menuFeign.findTypes());
        return modelAndView;
    }

    @GetMapping("preUpdate/{id}")
    public ModelAndView preUpdate(ModelAndView modelAndView,@PathVariable("id") long id){
        modelAndView.setViewName("menu_update");
        modelAndView.addObject("menu" ,menuFeign.getMenuById(id));
        modelAndView.addObject("list" ,menuFeign.findTypes());
        return modelAndView;
    }

    @PostMapping("/save")
    @ResponseBody
    public Result save(TMenu tMenu){
        return menuFeign.addMenu(tMenu);
    }

    @PostMapping("/update")
    @ResponseBody
    public Result update(TMenu tMenu){
        return menuFeign.updateMenu(tMenu);
    }



}
