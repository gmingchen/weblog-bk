package com.slipper.weblog.modules.category.service;

import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.core.mybatisplus.expand.IServiceX;
import com.slipper.weblog.modules.category.entity.CategoryEntity;
import com.slipper.weblog.modules.category.model.vo.CategoryBaseVO;
import com.slipper.weblog.modules.category.model.vo.CategoryPageVO;
import com.slipper.weblog.modules.category.model.dto.*;

import java.util.List;

/**
 * @author gumingchen
 */
public interface CategoryService extends IServiceX<CategoryEntity> {
    /**
     * 分页
     * @param dto 参数
     * @return
     */
    PageResult<CategoryPageVO> page(CategoryPageDTO dto);

    /**
     * 新增
     * @param dto 参数
     * @return
     */
    Long create(CategoryCreateDTO dto);

    /**
     * 更新
     * @param dto 参数
     */
    void update(CategoryUpdateDTO dto);

    /**
     * 更新排序
     * @param dto 参数
     */
    void updateSort(CategoryUpdateSortDTO dto);

    /**
     * 更新状态
     * @param dto 参数
     */
    void updateStatus(CategoryUpdateStatusDTO dto);

    /**
     * 删除
     * @param ids id数组
     */
    void delete(List<Long> ids);

    /**
     * 获取选择列表
     * @return
     */
    List<CategoryBaseVO> querySelectList();
}
