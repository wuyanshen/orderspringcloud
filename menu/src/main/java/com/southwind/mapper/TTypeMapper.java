package com.southwind.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.southwind.entity.TType;

public interface TTypeMapper extends BaseMapper<TType> {

    TType findById(long id);
}
