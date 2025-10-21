package com.slipper.weblog.modules.diary.service;

import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.core.mybatisplus.expand.IServiceX;
import com.slipper.weblog.modules.diary.entity.DiaryEntity;
import com.slipper.weblog.modules.diary.model.dto.DiaryInfoDTO;
import com.slipper.weblog.modules.diary.model.dto.DiaryPageDTO;
import com.slipper.weblog.modules.diary.model.vo.*;

/**
 * @author gumingchen
 */
public interface DiaryService extends IServiceX<DiaryEntity> {

    /**
     * 分页列表
     * @param reqVO 参数
     * @return
     */
    PageResult<DiaryPageDTO> page(DiaryPageReqVO reqVO);

    /**
     * 信息
     * @param id ID
     * @return
     */
    DiaryInfoDTO info(Long id);

    /**
     * 新增
     * @param reqVO 参数
     * @return
     */
    Long create(DiaryCreateReqVO reqVO);

    /**
     * 编辑
     * @param reqVO 参数
     */
    void update(DiaryUpdateReqVO reqVO);

    /**
     * 更新是否私密
     * @param reqVO 参数
     */
    void updatePrivate(DiaryUpdatePrivateReqVO reqVO);

    /**
     * 更新状态
     * @param reqVO 参数
     */
    void updateStatus(DiaryUpdateStatusReqVO reqVO);

    /**
     * 删除
     * @param id ID
     */
    void delete(Long id);
}
