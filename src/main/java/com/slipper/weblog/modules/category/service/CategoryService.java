package com.slipper.weblog.modules.category.service;

import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.core.mybatisplus.expand.IServiceX;
import com.slipper.weblog.modules.category.entity.CategoryEntity;
import com.slipper.weblog.modules.category.model.dto.CategoryPageDTO;
import com.slipper.weblog.modules.category.model.dto.CategorySelectDTO;
import com.slipper.weblog.modules.category.model.vo.*;

import java.util.List;

/**
 * @author gumingchen
 */
public interface CategoryService extends IServiceX<CategoryEntity> {
    /**
     * 分页
     * @param reqVO 参数
     * @return
     */
    PageResult<CategoryPageDTO> page(CategoryPageReqVO reqVO);

    /**
     * 新增
     * @param reqVO 参数
     * @return
     */
    Long create(CategoryCreateReqVO reqVO);

    /**
     * 更新
     * @param reqVO 参数
     */
    void update(CategoryUpdateReqVO reqVO);

    /**
     * 更新排序
     * @param reqVO 参数
     */
    void updateSort(CategoryUpdateSortReqVO reqVO);

    /**
     * 更新状态
     * @param reqVO 参数
     */
    void updateStatus(CategoryUpdateStatusReqVO reqVO);

    /**
     * 删除
     * @param ids id数组
     */
    void delete(List<Long> ids);

    /**
     * 获取选择列表
     * @return
     */
    List<CategorySelectDTO> querySelectList();
}
