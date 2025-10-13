package com.slipper.weblog.modules.column.service;

import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.core.mybatisplus.expand.IServiceX;
import com.slipper.weblog.modules.column.entity.ColumnEntity;
import com.slipper.weblog.modules.column.model.dto.ColumnPageDTO;
import com.slipper.weblog.modules.column.model.dto.ColumnSelectDTO;
import com.slipper.weblog.modules.column.model.vo.*;

import java.util.List;

/**
 * @author gumingchen
 */
public interface ColumnService extends IServiceX<ColumnEntity> {

    /**
     * 分页
     * @param reqVO 参数
     * @return
     */
    PageResult<ColumnPageDTO> page(ColumnPageReqVO reqVO);

    /**
     * 新增
     * @param reqVO 参数
     * @return
     */
    Long create(ColumnCreateReqVO reqVO);

    /**
     * 更新
     * @param reqVO 参数
     */
    void update(ColumnUpdateReqVO reqVO);

    /**
     * 更新排序
     * @param reqVO 参数
     */
    void updateSort(ColumnUpdateSortReqVO reqVO);

    /**
     * 更新状态
     * @param reqVO 参数
     */
    void updateStatus(ColumnUpdateStatusReqVO reqVO);

    /**
     * 删除
     * @param ids id数组
     */
    void delete(List<Long> ids);

    /**
     * 获取选择列表
     * @return
     */
    List<ColumnSelectDTO> querySelectList();

}
