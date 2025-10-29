package com.slipper.weblog.modules.tag.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.slipper.weblog.common.enums.StatusEnum;
import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.core.mybatisplus.expand.LambdaQueryWrapperX;
import com.slipper.weblog.core.mybatisplus.expand.ServiceImplX;
import com.slipper.weblog.exception.RunException;
import com.slipper.weblog.modules.tag.covert.TagConvert;
import com.slipper.weblog.modules.tag.entity.TagEntity;
import com.slipper.weblog.modules.tag.mapper.TagMapper;
import com.slipper.weblog.modules.tag.model.vo.TagBaseVO;
import com.slipper.weblog.modules.tag.model.dto.*;
import com.slipper.weblog.modules.tag.model.vo.TagPageVO;
import com.slipper.weblog.modules.tag.service.TagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gumingchen
 */
@Service("tagService")
public class TagServiceImpl extends ServiceImplX<TagMapper, TagEntity> implements TagService {

    @Override
    public PageResult<TagPageVO> page(TagPageDTO dto) {
        LambdaQueryWrapper<TagEntity> wrapper = new LambdaQueryWrapperX<TagEntity>()
                .likeIfPresent(TagEntity::getName, dto.getName())
                .eqIfPresent(TagEntity::getStatus, dto.getStatus())
                .orderByDesc(TagEntity::getSort)
                .orderByDesc(TagEntity::getCreatedAt);
        return TagConvert.INSTANCE.convert(baseMapper.selectPage(dto, wrapper));

    }

    @Override
    public Long create(TagCreateDTO dto) {
        TagEntity tagEntity = TagConvert.INSTANCE.convert(dto);
        baseMapper.insert(tagEntity);
        return tagEntity.getId();
    }

    @Override
    public void update(TagUpdateDTO dto) {
        TagEntity tagEntity = TagConvert.INSTANCE.convert(dto);
        baseMapper.updateById(tagEntity);
    }

    @Override
    public void updateSort(TagUpdateSortDTO dto) {
        List<TagEntity> list = dto.getIds().stream().map(id -> {
            TagEntity tagEntity = new TagEntity().setSort(dto.getSort());
            tagEntity.setId(id);
            return tagEntity;
        }).collect(Collectors.toList());
        baseMapper.updateBatchById(list);
    }

    @Override
    public void updateStatus(TagUpdateStatusDTO dto) {
        List<TagEntity> list = dto.getIds().stream().map(id -> {
            TagEntity tagEntity = new TagEntity().setStatus(dto.getStatus());
            tagEntity.setId(id);
            return tagEntity;
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
    public List<TagBaseVO> querySelectList() {
        LambdaQueryWrapper<TagEntity> wrapper = new LambdaQueryWrapper<TagEntity>()
                .eq(TagEntity::getStatus, StatusEnum.ENABLE.getCode())
                .orderByDesc(TagEntity::getSort)
                .orderByDesc(TagEntity::getCreatedAt);
        return TagConvert.INSTANCE.covertSelect(baseMapper.selectList(wrapper));
    }
}
