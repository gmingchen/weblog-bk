package com.slipper.weblog.modules.article.service;

import com.slipper.weblog.core.mybatisplus.expand.IServiceX;
import com.slipper.weblog.modules.article.entity.ArticleEntity;
import com.slipper.weblog.modules.article.model.dto.ArticleInfoVO;
import com.slipper.weblog.modules.article.model.vo.ArticleCreateDTO;
import com.slipper.weblog.modules.article.model.vo.ArticleUpdateDTO;
import com.slipper.weblog.modules.article.model.vo.ArticleUpdateFeaturedDTO;
import com.slipper.weblog.modules.article.model.vo.ArticleUpdateStatusDTO;

/**
 * @author gumingchen
 */
public interface ArticleService extends IServiceX<ArticleEntity> {

    /**
     * 信息
     * @param id ID
     * @return
     */
    ArticleInfoVO info(Long id);

    /**
     * 新增
     * @param dto 参数
     * @return
     */
    Long create(ArticleCreateDTO dto);

    /**
     * 编辑
     * @param dto 参数
     * @return
     */
    void update(ArticleUpdateDTO dto);

    /**
     * 更新是否精选
     * @param dto 参数
     */
    void updateFeatured(ArticleUpdateFeaturedDTO dto);

    /**
     * 更新状态
     * @param dto 参数
     */
    void updateStatus(ArticleUpdateStatusDTO dto);

    /**
     * 删除
     * @param id ID
     */
    void delete(Long id);

}
