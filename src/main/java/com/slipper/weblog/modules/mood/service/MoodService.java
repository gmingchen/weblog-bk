package com.slipper.weblog.modules.mood.service;

import com.slipper.weblog.core.mybatisplus.expand.IServiceX;
import com.slipper.weblog.modules.mood.entity.MoodEntity;
import com.slipper.weblog.modules.mood.model.MoodDTO;

import java.util.List;

/**
 * @author gumingchen
 */
public interface MoodService extends IServiceX<MoodEntity> {

    List<MoodDTO> queryList();
}
