package com.slipper.weblog.modules.diary.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.slipper.weblog.core.mybatisplus.expand.BaseMapperX;
import com.slipper.weblog.modules.diary.entity.DiaryEntity;
import com.slipper.weblog.modules.diary.model.vo.DiaryInfoVO;
import com.slipper.weblog.modules.diary.model.vo.DiaryPageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author gumingchen
 */
@Mapper
public interface DiaryMapper extends BaseMapperX<DiaryEntity> {

    IPage<DiaryPageVO> queryPage(Page<DiaryEntity> page,
                                 @Param("title") String title,
                                 @Param("moodId") Long moodId,
                                 @Param("weatherId") Long weatherId,
                                 @Param("isPrivate") Integer isPrivate,
                                 @Param("status") Integer status
    );

    DiaryInfoVO queryInfo(@Param("id") Long id);
}
