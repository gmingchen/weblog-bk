package com.slipper.weblog.modules.diary.service.impl;

import com.slipper.weblog.core.mybatisplus.expand.ServiceImplX;
import com.slipper.weblog.modules.diary.covert.DiaryConvert;
import com.slipper.weblog.modules.diary.entity.DiaryEntity;
import com.slipper.weblog.modules.diary.mapper.DiaryMapper;
import com.slipper.weblog.modules.diary.model.vo.DiaryCreateReqVO;
import com.slipper.weblog.modules.diary.model.vo.DiaryUpdateReqVO;
import com.slipper.weblog.modules.diary.model.vo.DiaryUpdateStatusReqVO;
import com.slipper.weblog.modules.diary.service.DiaryService;
import org.springframework.stereotype.Service;

/**
 * @author gumingchen
 */
@Service("diaryService")
public class DiaryServiceImpl extends ServiceImplX<DiaryMapper, DiaryEntity> implements DiaryService {

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
    public void updateStatus(DiaryUpdateStatusReqVO reqVO) {
        DiaryEntity diaryEntity = DiaryConvert.INSTANCE.convert(reqVO);
        baseMapper.updateById(diaryEntity);
    }

    @Override
    public void delete(Long id) {
        this.removeById(id);
    }
}
