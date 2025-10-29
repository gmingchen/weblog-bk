package com.slipper.weblog.modules.tag.service;

import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.core.mybatisplus.expand.IServiceX;
import com.slipper.weblog.modules.tag.entity.TagEntity;
import com.slipper.weblog.modules.tag.model.vo.TagBaseVO;
import com.slipper.weblog.modules.tag.model.dto.*;
import com.slipper.weblog.modules.tag.model.vo.TagPageVO;

import java.util.List;

/**
 * @author gumingchen
 */
public interface TagService extends IServiceX<TagEntity> {

    /**
     * 分页
     * @param dto 参数
     * @return
     */
    PageResult<TagPageVO> page(TagPageDTO dto);

    /**
     * 新增
     * @param dto 参数
     * @return
     */
    Long create(TagCreateDTO dto);

    /**
     * 更新
     * @param dto 参数
     */
    void update(TagUpdateDTO dto);

    /**
     * 更新排序
     * @param dto 参数
     */
    void updateSort(TagUpdateSortDTO dto);

    /**
     * 更新状态
     * @param dto 参数
     */
    void updateStatus(TagUpdateStatusDTO dto);

    /**
     * 删除
     * @param ids id数组
     */
    void delete(List<Long> ids);

    /**
     * 获取选择列表
     * @return
     */
    List<TagBaseVO> querySelectList();
}
