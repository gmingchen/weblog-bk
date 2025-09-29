package com.slipper.weblog.core.mybatisplus.expand;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.slipper.weblog.common.pojo.PageParam;
import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.core.mybatisplus.utils.MyBatisUtils;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface BaseMapperX<T> extends BaseMapper<T> {
    /**
     * 分页查询
     * @param pageParam
     * @param wrapper
     * @return
     */
    default PageResult<T> selectPage(PageParam pageParam, @Param(Constants.WRAPPER) Wrapper<T> wrapper) {
        IPage<T> page = MyBatisUtils.buildPage(pageParam);
        selectPage(page, wrapper);
        return new PageResult<>(page.getTotal(), page.getPages(), page.getRecords());
    }
    /**
     * 批量插入
     * @param entities 实体对象集合
     */
    default void insertBatch(Collection<T> entities) {
        Db.saveBatch(entities);
    }
    /**
     * 批量插入
     * @param entities 实体对象集合
     * @param size 插入批次数量
     */
    default void insertBatch(Collection<T> entities, int size) {
        Db.saveBatch(entities, size);
    }
    /**
     * 更新
     * @param wrapper
     */
    default void update(Wrapper<T> wrapper) {
        update(null, wrapper);
    }
    /**
     * 批量更新
     * @param entity 实体对象
     */
    default void updateBatch(T entity) {
        update(entity, new QueryWrapper<>());
    }
    /**
     * 批量更新
     * @param entities 实体对象集合
     */
    default void updateBatchById(Collection<T> entities) {
        Db.updateBatchById(entities);
    }
    /**
     * 批量更新
     * @param entities 实体对象集合
     * @param size 插入批次数量
     */
    default void updateBatchById(Collection<T> entities, int size) {
        Db.updateBatchById(entities, size);
    }

    /**
     * 查询列表
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     * @param limit 限制数量
     * @return
     */
    default List<T> selectList(@Param(Constants.WRAPPER) LambdaQueryWrapper<T> queryWrapper, Integer limit) {
        queryWrapper.last("limit " + limit);
        return this.selectList(queryWrapper);
    }

    /**
     * 查询列表中的第一个对象
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     * @return
     */
    default T selectOne(@Param(Constants.WRAPPER) LambdaQueryWrapper<T> queryWrapper) {
        queryWrapper.last("limit 1");
        List<T> list = this.selectList(queryWrapper);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
