package com.southwind.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.southwind.mapper.TMenuMapper;
import com.southwind.entity.TMenu;
import com.southwind.service.TMenuService;
@Service
public class TMenuServiceImpl extends ServiceImpl<TMenuMapper, TMenu> implements TMenuService{

    public IPage<TMenu> findAll(Page page) {
        return baseMapper.findAll(page);
    }

    public Boolean saveMenu(TMenu tMenu) {
        return baseMapper.addMenu(tMenu);
    }

    public Boolean updateMenu(TMenu tMenu) {
        return baseMapper.updateMenu(tMenu);
    }

    public TMenu findMenuBydId(long id) {
        return baseMapper.findMenuById(id);
    }
}
