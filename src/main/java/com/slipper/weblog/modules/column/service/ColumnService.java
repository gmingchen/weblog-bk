package com.slipper.weblog.modules.column.service;

import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.core.mybatisplus.expand.IServiceX;
import com.slipper.weblog.modules.column.entity.ColumnEntity;
import com.slipper.weblog.modules.column.model.vo.ColumnBaseVO;
import com.slipper.weblog.modules.column.model.vo.ColumnPageVO;
import com.slipper.weblog.modules.column.model.dto.*;

import java.util.List;

/**
 * @author gumingchen
 */
public interface ColumnService extends IServiceX<ColumnEntity> {

    /**
     * 分页
     * @param dto 参数
     * @return
     */
    PageResult<ColumnPageVO> page(ColumnPageDTO dto);

    /**
     * 新增
     * @param dto 参数
     * @return
     */
    Long create(ColumnCreateDTO dto);

    /**
     * 更新
     * @param dto 参数
     */
    void update(ColumnUpdateReqVO dto);

    /**
     * 更新排序
     * @param dto 参数
     */
    void updateSort(ColumnUpdateSortDTO dto);

    /**
     * 更新状态
     * @param dto 参数
     */
    void updateStatus(ColumnUpdateStatusDTO dto);

    /**
     * 删除
     * @param ids id数组
     */
    void delete(List<Long> ids);

    /**
     * 获取选择列表
     * @return
     */
    List<ColumnBaseVO> querySelectList();

}
