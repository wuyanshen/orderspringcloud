package com.southwind.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.southwind.entity.TMenu;
import com.baomidou.mybatisplus.extension.service.IService;
public interface TMenuService extends IService<TMenu>{

    IPage<TMenu> findAll(Page page);

    Boolean saveMenu(TMenu tMenu);

    Boolean updateMenu(TMenu tMenu);

    TMenu findMenuBydId(long id);
}
