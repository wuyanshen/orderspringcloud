package com.southwind.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.southwind.entity.TType;
import com.southwind.mapper.TTypeMapper;
import com.southwind.service.TTypeService;
@Service
public class TTypeServiceImpl extends ServiceImpl<TTypeMapper, TType> implements TTypeService{

}
