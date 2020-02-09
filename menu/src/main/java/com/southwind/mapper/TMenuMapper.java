package com.southwind.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.southwind.entity.TMenu;

public interface TMenuMapper extends BaseMapper<TMenu> {

    IPage<TMenu> findAll(Page page);

    Boolean addMenu(TMenu tMenu);

    TMenu findMenuById(long id);

    Boolean updateMenu(TMenu tMenu);
}
