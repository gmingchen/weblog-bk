package com.slipper.weblog.modules.mood.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.slipper.weblog.modules.mood.entity.MoodEntity;
import com.slipper.weblog.modules.mood.model.MoodDTO;

import java.util.List;

/**
 * @author gumingchen
 */
public interface MoodService extends IService<MoodEntity> {

    List<MoodDTO> queryList();
}
