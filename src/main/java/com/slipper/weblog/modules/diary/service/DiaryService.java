package com.slipper.weblog.modules.diary.service;

import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.core.mybatisplus.expand.IServiceX;
import com.slipper.weblog.modules.diary.entity.DiaryEntity;
import com.slipper.weblog.modules.diary.model.dto.*;
import com.slipper.weblog.modules.diary.model.vo.*;

/**
 * @author gumingchen
 */
public interface DiaryService extends IServiceX<DiaryEntity> {

    /**
     * 分页列表
     * @param dto 参数
     * @return
     */
    PageResult<DiaryPageVO> page(DiaryPageDTO dto);

    /**
     * 信息
     * @param id ID
     * @return
     */
    DiaryInfoVO info(Long id);

    /**
     * 新增
     * @param dto 参数
     * @return
     */
    Long create(DiaryCreateDTO dto);

    /**
     * 编辑
     * @param dto 参数
     */
    void update(DiaryUpdateDTO dto);

    /**
     * 更新是否私密
     * @param dto 参数
     */
    void updatePrivate(DiaryUpdatePrivateDTO dto);

    /**
     * 更新状态
     * @param dto 参数
     */
    void updateStatus(DiaryUpdateStatusDTO dto);

    /**
     * 删除
     * @param id ID
     */
    void delete(Long id);
}
