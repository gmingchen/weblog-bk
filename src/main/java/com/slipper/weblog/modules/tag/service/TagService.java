package com.slipper.weblog.modules.tag.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.modules.tag.entity.TagEntity;
import com.slipper.weblog.modules.tag.model.dto.TagPageDTO;
import com.slipper.weblog.modules.tag.model.dto.TagSelectDTO;
import com.slipper.weblog.modules.tag.model.vo.TagCreateReqVO;
import com.slipper.weblog.modules.tag.model.vo.TagPageReqVO;
import com.slipper.weblog.modules.tag.model.vo.TagUpdateReqVO;

import java.util.List;

/**
 * @author gumingchen
 */
public interface TagService extends IService<TagEntity> {

    /**
     * 分页
     * @param reqVO 参数
     * @return
     */
    PageResult<TagPageDTO> page(TagPageReqVO reqVO);

    /**
     * 新增
     * @param reqVO 参数
     * @return
     */
    Long create(TagCreateReqVO reqVO);

    /**
     * 更新
     * @param reqVO 参数
     */
    void update(TagUpdateReqVO reqVO);

    /**
     * 删除
     * @param ids id数组
     */
    void delete(List<Long> ids);

    /**
     * 获取选择列表
     * @return
     */
    List<TagSelectDTO> querySelectList();
}
