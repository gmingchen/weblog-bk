package com.slipper.weblog.modules.column.service.impl;

import com.slipper.weblog.core.mybatisplus.expand.ServiceImplX;
import com.slipper.weblog.modules.column.entity.ColumnEntity;
import com.slipper.weblog.modules.column.mapper.ColumnMapper;
import com.slipper.weblog.modules.column.service.ColumnService;
import org.springframework.stereotype.Service;

/**
 * @author gumingchen
 */
@Service("columnService")
public class ColumnServiceImpl extends ServiceImplX<ColumnMapper, ColumnEntity> implements ColumnService {


}
