package com.slipper.weblog.modules.diary.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.core.mybatisplus.expand.ServiceImplX;
import com.slipper.weblog.modules.diary.covert.DiaryConvert;
import com.slipper.weblog.modules.diary.entity.DiaryEntity;
import com.slipper.weblog.modules.diary.mapper.DiaryMapper;
import com.slipper.weblog.modules.diary.model.dto.*;
import com.slipper.weblog.modules.diary.model.vo.*;
import com.slipper.weblog.modules.diary.service.DiaryService;
import org.springframework.stereotype.Service;

/**
 * @author gumingchen
 */
@Service("diaryService")
public class DiaryServiceImpl extends ServiceImplX<DiaryMapper, DiaryEntity> implements DiaryService {

    @Override
    public PageResult<DiaryPageVO> page(DiaryPageDTO dto) {
        Page<DiaryEntity> page = new Page<>(dto.getCurrent(), dto.getSize());
        IPage<DiaryPageVO> result = baseMapper.queryPage(
                page,
                dto.getTitle(),
                dto.getMoodId(),
                dto.getWeatherId(),
                dto.getIsPrivate(),
                dto.getStatus()
        );
        return new PageResult<>(
                result.getTotal(), result.getPages(), result.getRecords()
        );
    }

    @Override
    public DiaryInfoVO info(Long id) {
        return baseMapper.queryInfo(id);
    }

    @Override
    public Long create(DiaryCreateDTO dto) {
        DiaryEntity diaryEntity = DiaryConvert.INSTANCE.convert(dto);
        baseMapper.insert(diaryEntity);
        return diaryEntity.getId();
    }

    @Override
    public void update(DiaryUpdateDTO dto) {
        DiaryEntity diaryEntity = DiaryConvert.INSTANCE.convert(dto);
        baseMapper.updateById(diaryEntity);
    }

    @Override
    public void updatePrivate(DiaryUpdatePrivateDTO dto) {
        DiaryEntity diaryEntity = DiaryConvert.INSTANCE.convert(dto);
        baseMapper.updateById(diaryEntity);
    }

    @Override
    public void updateStatus(DiaryUpdateStatusDTO dto) {
        DiaryEntity diaryEntity = DiaryConvert.INSTANCE.convert(dto);
        baseMapper.updateById(diaryEntity);
    }

    @Override
    public void delete(Long id) {
        this.removeById(id);
    }
}
