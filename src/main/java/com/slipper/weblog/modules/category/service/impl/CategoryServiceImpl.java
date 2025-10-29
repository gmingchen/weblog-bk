package com.slipper.weblog.modules.category.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.slipper.weblog.common.enums.StatusEnum;
import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.core.mybatisplus.expand.LambdaQueryWrapperX;
import com.slipper.weblog.core.mybatisplus.expand.ServiceImplX;
import com.slipper.weblog.exception.RunException;
import com.slipper.weblog.modules.category.covert.CategoryConvert;
import com.slipper.weblog.modules.category.entity.CategoryEntity;
import com.slipper.weblog.modules.category.mapper.CategoryMapper;
import com.slipper.weblog.modules.category.model.vo.CategoryBaseVO;
import com.slipper.weblog.modules.category.model.vo.CategoryPageVO;
import com.slipper.weblog.modules.category.model.dto.*;
import com.slipper.weblog.modules.category.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gumingchen
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImplX<CategoryMapper, CategoryEntity> implements CategoryService {

    @Override
    public PageResult<CategoryPageVO> page(CategoryPageDTO dto) {
        LambdaQueryWrapper<CategoryEntity> wrapper = new LambdaQueryWrapperX<CategoryEntity>()
                .likeIfPresent(CategoryEntity::getName, dto.getName())
                .eqIfPresent(CategoryEntity::getStatus, dto.getStatus())
                .eq(CategoryEntity::getParentId, dto.getParentId())
                .orderByDesc(CategoryEntity::getSort)
                .orderByDesc(CategoryEntity::getCreatedAt);
        return CategoryConvert.INSTANCE.convert(baseMapper.selectPage(dto, wrapper));
    }

    @Override
    public Long create(CategoryCreateDTO dto) {
        CategoryEntity categoryEntity = CategoryConvert.INSTANCE.convert(dto);
        baseMapper.insert(categoryEntity);
        return categoryEntity.getId();
    }

    @Override
    public void update(CategoryUpdateDTO dto) {
        CategoryEntity categoryEntity = CategoryConvert.INSTANCE.convert(dto);
        baseMapper.updateById(categoryEntity);
    }

    @Override
    public void updateSort(CategoryUpdateSortDTO dto) {
        List<CategoryEntity> list = dto.getIds().stream().map(id -> {
            CategoryEntity categoryEntity = new CategoryEntity().setSort(dto.getSort());
            categoryEntity.setId(id);
            return categoryEntity;
        }).collect(Collectors.toList());
        baseMapper.updateBatchById(list);
    }

    @Override
    public void updateStatus(CategoryUpdateStatusDTO dto) {
        List<CategoryEntity> list = dto.getIds().stream().map(id -> {
            CategoryEntity categoryEntity = new CategoryEntity().setStatus(dto.getStatus());
            categoryEntity.setId(id);
            return categoryEntity;
        }).collect(Collectors.toList());
        baseMapper.updateBatchById(list);
    }

    @Transactional(rollbackFor = RunException.class)
    @Override
    public void delete(List<Long> ids) {
        for(Long id : ids) {
            this.removeById(id);
        }
    }

    @Override
    public List<CategoryBaseVO> querySelectList() {
        LambdaQueryWrapper<CategoryEntity> wrapper = new LambdaQueryWrapper<CategoryEntity>()
                .eq(CategoryEntity::getStatus, StatusEnum.ENABLE.getCode())
                .orderByDesc(CategoryEntity::getSort)
                .orderByDesc(CategoryEntity::getCreatedAt);
        return CategoryConvert.INSTANCE.covertSelect(baseMapper.selectList(wrapper));
    }
}
