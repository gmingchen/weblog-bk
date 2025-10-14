package com.slipper.weblog.modules.column.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.slipper.weblog.common.enums.StatusEnum;
import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.core.mybatisplus.expand.LambdaQueryWrapperX;
import com.slipper.weblog.core.mybatisplus.expand.ServiceImplX;
import com.slipper.weblog.exception.RunException;
import com.slipper.weblog.modules.column.entity.ColumnEntity;
import com.slipper.weblog.modules.column.mapper.ColumnMapper;
import com.slipper.weblog.modules.column.service.ColumnService;
import com.slipper.weblog.modules.column.covert.ColumnConvert;
import com.slipper.weblog.modules.column.model.dto.ColumnPageDTO;
import com.slipper.weblog.modules.column.model.dto.ColumnSelectDTO;
import com.slipper.weblog.modules.column.model.vo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gumingchen
 */
@Service("columnService")
public class ColumnServiceImpl extends ServiceImplX<ColumnMapper, ColumnEntity> implements ColumnService {

    @Override
    public PageResult<ColumnPageDTO> page(ColumnPageReqVO reqVO) {
        LambdaQueryWrapper<ColumnEntity> wrapper = new LambdaQueryWrapperX<ColumnEntity>()
                .likeIfPresent(ColumnEntity::getName, reqVO.getName())
                .eqIfPresent(ColumnEntity::getStatus, reqVO.getStatus())
                .orderByDesc(ColumnEntity::getSort)
                .orderByDesc(ColumnEntity::getCreatedAt);
        return ColumnConvert.INSTANCE.convert(baseMapper.selectPage(reqVO, wrapper));

    }

    @Override
    public Long create(ColumnCreateReqVO reqVO) {
        ColumnEntity columnEntity = ColumnConvert.INSTANCE.convert(reqVO);
        baseMapper.insert(columnEntity);
        return columnEntity.getId();
    }

    @Override
    public void update(ColumnUpdateReqVO reqVO) {
        ColumnEntity columnEntity = ColumnConvert.INSTANCE.convert(reqVO);
        baseMapper.updateById(columnEntity);
    }

    @Override
    public void updateSort(ColumnUpdateSortReqVO reqVO) {
        List<ColumnEntity> list = reqVO.getIds().stream().map(id -> {
            ColumnEntity columnEntity = new ColumnEntity().setSort(reqVO.getSort());
            columnEntity.setId(id);
            return columnEntity;
        }).collect(Collectors.toList());
        baseMapper.updateBatchById(list);
    }

    @Override
    public void updateStatus(ColumnUpdateStatusReqVO reqVO) {
        List<ColumnEntity> list = reqVO.getIds().stream().map(id -> {
            ColumnEntity columnEntity = new ColumnEntity().setStatus(reqVO.getStatus());
            columnEntity.setId(id);
            return columnEntity;
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
    public List<ColumnSelectDTO> querySelectList() {
        LambdaQueryWrapper<ColumnEntity> wrapper = new LambdaQueryWrapper<ColumnEntity>()
                .eq(ColumnEntity::getStatus, StatusEnum.ENABLE.getCode())
                .orderByDesc(ColumnEntity::getSort)
                .orderByDesc(ColumnEntity::getCreatedAt);
        return ColumnConvert.INSTANCE.covertSelect(baseMapper.selectList(wrapper));
    }

}
