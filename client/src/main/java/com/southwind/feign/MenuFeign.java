package com.southwind.feign;

import com.southwind.common.Result;
import com.southwind.entity.TMenu;
import com.southwind.entity.TType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "menu")
public interface MenuFeign {

    @GetMapping("/menu/findAll")
    Result<List<TMenu>> findAll(@RequestParam("current") long current, @RequestParam("size")long size);

    @DeleteMapping("/menu/delete/{id}")
    Result delete(@PathVariable("id") long id);

    @GetMapping("/menu/findTypes")
    List<TType> findTypes();

    @GetMapping("/menu/findById/{id}")
    TMenu getMenuById(@PathVariable("id") long id);

    @PostMapping("/menu/add")
    Result addMenu(TMenu tMenu);

    @PostMapping("/menu/update")
    Result updateMenu(@RequestBody TMenu tMenu);
}
