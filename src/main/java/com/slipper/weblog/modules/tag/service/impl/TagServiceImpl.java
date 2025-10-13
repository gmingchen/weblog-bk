package com.slipper.weblog.modules.tag.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.slipper.weblog.common.enums.StatusEnum;
import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.core.mybatisplus.expand.LambdaQueryWrapperX;
import com.slipper.weblog.core.mybatisplus.expand.ServiceImplX;
import com.slipper.weblog.modules.tag.covert.TagConvert;
import com.slipper.weblog.modules.tag.entity.TagEntity;
import com.slipper.weblog.modules.tag.mapper.TagMapper;
import com.slipper.weblog.modules.tag.model.dto.TagPageDTO;
import com.slipper.weblog.modules.tag.model.dto.TagSelectDTO;
import com.slipper.weblog.modules.tag.model.vo.*;
import com.slipper.weblog.modules.tag.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gumingchen
 */
@Service("tagService")
public class TagServiceImpl extends ServiceImplX<TagMapper, TagEntity> implements TagService {

    @Override
    public PageResult<TagPageDTO> page(TagPageReqVO reqVO) {
        LambdaQueryWrapper<TagEntity> wrapper = new LambdaQueryWrapperX<TagEntity>()
                .likeIfPresent(TagEntity::getName, reqVO.getName())
                .orderByDesc(TagEntity::getSort)
                .orderByDesc(TagEntity::getCreatedAt);
        return TagConvert.INSTANCE.convert(baseMapper.selectPage(reqVO, wrapper));

    }

    @Override
    public Long create(TagCreateReqVO reqVO) {
        TagEntity tagEntity = TagConvert.INSTANCE.convert(reqVO);
        baseMapper.insert(tagEntity);
        return tagEntity.getId();
    }

    @Override
    public void update(TagUpdateReqVO reqVO) {
        TagEntity tagEntity = TagConvert.INSTANCE.convert(reqVO);
        baseMapper.updateById(tagEntity);
    }

    @Override
    public void updateSort(TagUpdateSortReqVO reqVO) {
        List<TagEntity> list = reqVO.getIds().stream().map(id -> {
            TagEntity tagEntity = new TagEntity().setSort(reqVO.getSort());
            tagEntity.setId(id);
            return tagEntity;
        }).collect(Collectors.toList());
        baseMapper.updateBatchById(list);
    }

    @Override
    public void updateStatus(TagUpdateStatusReqVO reqVO) {
        List<TagEntity> list = reqVO.getIds().stream().map(id -> {
            TagEntity tagEntity = new TagEntity().setStatus(reqVO.getStatus());
            tagEntity.setId(id);
            return tagEntity;
        }).collect(Collectors.toList());
        baseMapper.updateBatchById(list);
    }

    @Override
    public void delete(List<Long> ids) {
        this.removeBatchByIds(ids);
        baseMapper.deleteBatchIds();
    }

    @Override
    public List<TagSelectDTO> querySelectList() {
        LambdaQueryWrapper<TagEntity> wrapper = new LambdaQueryWrapper<TagEntity>()
                .eq(TagEntity::getStatus, StatusEnum.ENABLE.getCode())
                .orderByDesc(TagEntity::getSort)
                .orderByDesc(TagEntity::getCreatedAt);;
        return TagConvert.INSTANCE.covertSelect(baseMapper.selectList(wrapper));
    }
}
