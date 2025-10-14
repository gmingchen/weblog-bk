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
import com.slipper.weblog.modules.category.model.dto.CategoryPageDTO;
import com.slipper.weblog.modules.category.model.dto.CategorySelectDTO;
import com.slipper.weblog.modules.category.model.vo.*;
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
    public PageResult<CategoryPageDTO> page(CategoryPageReqVO reqVO) {
        LambdaQueryWrapper<CategoryEntity> wrapper = new LambdaQueryWrapperX<CategoryEntity>()
                .likeIfPresent(CategoryEntity::getName, reqVO.getName())
                .eqIfPresent(CategoryEntity::getStatus, reqVO.getStatus())
                .eq(CategoryEntity::getParentId, reqVO.getParentId())
                .orderByDesc(CategoryEntity::getSort)
                .orderByDesc(CategoryEntity::getCreatedAt);
        return CategoryConvert.INSTANCE.convert(baseMapper.selectPage(reqVO, wrapper));
    }

    @Override
    public Long create(CategoryCreateReqVO reqVO) {
        CategoryEntity categoryEntity = CategoryConvert.INSTANCE.convert(reqVO);
        baseMapper.insert(categoryEntity);
        return categoryEntity.getId();
    }

    @Override
    public void update(CategoryUpdateReqVO reqVO) {
        CategoryEntity categoryEntity = CategoryConvert.INSTANCE.convert(reqVO);
        baseMapper.updateById(categoryEntity);
    }

    @Override
    public void updateSort(CategoryUpdateSortReqVO reqVO) {
        List<CategoryEntity> list = reqVO.getIds().stream().map(id -> {
            CategoryEntity categoryEntity = new CategoryEntity().setSort(reqVO.getSort());
            categoryEntity.setId(id);
            return categoryEntity;
        }).collect(Collectors.toList());
        baseMapper.updateBatchById(list);
    }

    @Override
    public void updateStatus(CategoryUpdateStatusReqVO reqVO) {
        List<CategoryEntity> list = reqVO.getIds().stream().map(id -> {
            CategoryEntity categoryEntity = new CategoryEntity().setStatus(reqVO.getStatus());
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
    public List<CategorySelectDTO> querySelectList() {
        LambdaQueryWrapper<CategoryEntity> wrapper = new LambdaQueryWrapper<CategoryEntity>()
                .eq(CategoryEntity::getStatus, StatusEnum.ENABLE.getCode())
                .orderByDesc(CategoryEntity::getSort)
                .orderByDesc(CategoryEntity::getCreatedAt);
        return CategoryConvert.INSTANCE.covertSelect(baseMapper.selectList(wrapper));
    }
}
