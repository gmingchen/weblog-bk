package com.slipper.weblog.modules.category.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.weblog.modules.category.entity.CategoryEntity;
import com.slipper.weblog.modules.category.mapper.CategoryMapper;
import com.slipper.weblog.modules.category.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * @author gumingchen
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryEntity> implements CategoryService {


}
