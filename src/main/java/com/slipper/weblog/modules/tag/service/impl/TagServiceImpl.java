package com.slipper.weblog.modules.tag.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.weblog.common.enums.StatusEnum;
import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.core.mybatisplus.expand.LambdaQueryWrapperX;
import com.slipper.weblog.core.mybatisplus.utils.MyBatisUtils;
import com.slipper.weblog.modules.tag.covert.TagConvert;
import com.slipper.weblog.modules.tag.entity.TagEntity;
import com.slipper.weblog.modules.tag.mapper.TagMapper;
import com.slipper.weblog.modules.tag.model.dto.TagPageDTO;
import com.slipper.weblog.modules.tag.model.dto.TagSelectDTO;
import com.slipper.weblog.modules.tag.model.vo.TagCreateReqVO;
import com.slipper.weblog.modules.tag.model.vo.TagPageReqVO;
import com.slipper.weblog.modules.tag.model.vo.TagUpdateReqVO;
import com.slipper.weblog.modules.tag.service.TagService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author gumingchen
 */
@Service("tagService")
public class TagServiceImpl extends ServiceImpl<TagMapper, TagEntity> implements TagService {

    @Override
    public PageResult<TagPageDTO> page(TagPageReqVO reqVO) {
        LambdaQueryWrapper<TagEntity> wrapper = new LambdaQueryWrapperX<TagEntity>()
                .likeIfPresent(TagEntity::getName, reqVO.getName())
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
    public void delete(List<Long> ids) {
        baseMapper.deleteBatchIds(ids);
    }

    @Override
    public List<TagSelectDTO> querySelectList() {
        LambdaQueryWrapper<TagEntity> wrapper = new LambdaQueryWrapper<TagEntity>()
                .eq(TagEntity::getStatus, StatusEnum.ENABLE.getCode());
        return TagConvert.INSTANCE.covertSelect(baseMapper.selectList(wrapper));
    }
}
