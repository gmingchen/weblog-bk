package com.slipper.weblog.modules.diary.service.impl;

import com.slipper.weblog.core.mybatisplus.expand.ServiceImplX;
import com.slipper.weblog.modules.diary.entity.DiaryEntity;
import com.slipper.weblog.modules.diary.mapper.DiaryMapper;
import com.slipper.weblog.modules.diary.service.DiaryService;
import org.springframework.stereotype.Service;

/**
 * @author gumingchen
 */
@Service("diaryService")
public class DiaryServiceImpl extends ServiceImplX<DiaryMapper, DiaryEntity> implements DiaryService {
}
