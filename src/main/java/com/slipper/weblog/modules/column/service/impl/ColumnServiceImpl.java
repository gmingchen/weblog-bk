package com.slipper.weblog.modules.column.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.weblog.modules.column.entity.ColumnEntity;
import com.slipper.weblog.modules.column.mapper.ColumnMapper;
import com.slipper.weblog.modules.column.service.ColumnService;
import org.springframework.stereotype.Service;

/**
 * @author gumingchen
 */
@Service("columnService")
public class ColumnServiceImpl extends ServiceImpl<ColumnMapper, ColumnEntity> implements ColumnService {


}
