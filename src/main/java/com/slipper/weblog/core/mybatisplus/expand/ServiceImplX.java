package com.slipper.weblog.core.mybatisplus.expand;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.weblog.exception.RunException;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author gumingchen
 */
public class ServiceImplX<M extends BaseMapperX<T>, T> extends ServiceImpl<M, T> implements IServiceX<T> {

    @Transactional(rollbackFor = RunException.class)
    @Override
    public void saveOrRemoveBatch(
            Serializable primaryId,
            Collection<?> modifiedIds,
            SFunction<T, ?> selectEqColumnFn,
            Function<T, Serializable> modifiedIdMap,
            Function<Serializable, T> insertMap,
            SFunction<T, ?> deleteInColumnFn) {
        LambdaQueryWrapper<T> wrapper = new LambdaQueryWrapperX<T>()
                .eq(selectEqColumnFn, primaryId);
        Collection<Serializable> allIds = baseMapper.selectList(wrapper)
                .stream()
                .map(modifiedIdMap)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        List<Serializable> ids = modifiedIds
                .stream()
                .map(Serializable.class::cast)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        List<Serializable> createIds = CollUtil.subtractToList(ids, allIds);
        List<Serializable> deleteIds = CollUtil.subtractToList(allIds, ids);

        if (CollUtil.isNotEmpty(createIds)) {
            baseMapper.insertBatch(
                    createIds
                            .stream()
                            .map(insertMap)
                            .filter(Objects::nonNull)
                            .collect(Collectors.toList())
            );
        }
        if (CollUtil.isNotEmpty(deleteIds)) {
            LambdaUpdateWrapper<T> updateWrapper = new LambdaUpdateWrapper<T>()
                    .eq(selectEqColumnFn, primaryId)
                    .in(deleteInColumnFn, deleteIds);
            baseMapper.delete(updateWrapper);
        }
    }
}