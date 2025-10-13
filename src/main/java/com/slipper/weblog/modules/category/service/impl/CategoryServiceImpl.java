package com.slipper.weblog.modules.category.service.impl;

import com.slipper.weblog.core.mybatisplus.expand.ServiceImplX;
import com.slipper.weblog.modules.category.entity.CategoryEntity;
import com.slipper.weblog.modules.category.mapper.CategoryMapper;
import com.slipper.weblog.modules.category.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * @author gumingchen
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImplX<CategoryMapper, CategoryEntity> implements CategoryService {


}
