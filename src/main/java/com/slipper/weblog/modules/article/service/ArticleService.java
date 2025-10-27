package com.slipper.weblog.modules.article.service;

import com.slipper.weblog.core.mybatisplus.expand.IServiceX;
import com.slipper.weblog.modules.article.entity.ArticleEntity;
import com.slipper.weblog.modules.article.model.vo.ArticleCreateReqVO;
import com.slipper.weblog.modules.article.model.vo.ArticleUpdateFeaturedReqVO;
import com.slipper.weblog.modules.article.model.vo.ArticleUpdateReqVO;
import com.slipper.weblog.modules.article.model.vo.ArticleUpdateStatusReqVO;

/**
 * @author gumingchen
 */
public interface ArticleService extends IServiceX<ArticleEntity> {

    /**
     * 新增
     * @param reqVO 参数
     * @return
     */
    Long create(ArticleCreateReqVO reqVO);

    /**
     * 编辑
     * @param reqVO 参数
     * @return
     */
    void update(ArticleUpdateReqVO reqVO);

    /**
     * 更新是否精选
     * @param reqVO 参数
     */
    void updateFeatured(ArticleUpdateFeaturedReqVO reqVO);

    /**
     * 更新状态
     * @param reqVO 参数
     */
    void updateStatus(ArticleUpdateStatusReqVO reqVO);

    /**
     * 删除
     * @param id ID
     */
    void delete(Long id);

}
