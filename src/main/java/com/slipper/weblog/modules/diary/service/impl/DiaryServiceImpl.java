package com.slipper.weblog.modules.diary.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.core.mybatisplus.expand.ServiceImplX;
import com.slipper.weblog.modules.diary.covert.DiaryConvert;
import com.slipper.weblog.modules.diary.entity.DiaryEntity;
import com.slipper.weblog.modules.diary.mapper.DiaryMapper;
import com.slipper.weblog.modules.diary.model.dto.DiaryInfoDTO;
import com.slipper.weblog.modules.diary.model.dto.DiaryPageDTO;
import com.slipper.weblog.modules.diary.model.vo.*;
import com.slipper.weblog.modules.diary.service.DiaryService;
import org.springframework.stereotype.Service;

/**
 * @author gumingchen
 */
@Service("diaryService")
public class DiaryServiceImpl extends ServiceImplX<DiaryMapper, DiaryEntity> implements DiaryService {

    @Override
    public PageResult<DiaryPageDTO> page(DiaryPageReqVO reqVO) {
        Page<DiaryEntity> page = new Page<>(reqVO.getCurrent(), reqVO.getSize());
        IPage<DiaryPageDTO> result = baseMapper.queryPage(
                page,
                reqVO.getTitle(),
                reqVO.getMoodId(),
                reqVO.getWeatherId(),
                reqVO.getIsPrivate(),
                reqVO.getStatus()
        );
        return new PageResult<>(
                result.getTotal(), result.getPages(), result.getRecords()
        );
    }

    @Override
    public DiaryInfoDTO info(Long id) {
        return baseMapper.queryInfo(id);
    }

    @Override
    public Long create(DiaryCreateReqVO reqVO) {
        DiaryEntity diaryEntity = DiaryConvert.INSTANCE.convert(reqVO);
        baseMapper.insert(diaryEntity);
        return diaryEntity.getId();
    }

    @Override
    public void update(DiaryUpdateReqVO reqVO) {
        DiaryEntity diaryEntity = DiaryConvert.INSTANCE.convert(reqVO);
        baseMapper.updateById(diaryEntity);
    }

    @Override
    public void updatePrivate(DiaryUpdatePrivateReqVO reqVO) {
        DiaryEntity diaryEntity = DiaryConvert.INSTANCE.convert(reqVO);
        baseMapper.updateById(diaryEntity);
    }

    @Override
    public void updateStatus(DiaryUpdateStatusReqVO reqVO) {
        DiaryEntity diaryEntity = DiaryConvert.INSTANCE.convert(reqVO);
        baseMapper.updateById(diaryEntity);
    }

    @Override
    public void delete(Long id) {
        this.removeById(id);
    }
}
