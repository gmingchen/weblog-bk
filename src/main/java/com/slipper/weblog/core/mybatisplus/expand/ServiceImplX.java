package com.slipper.weblog.core.mybatisplus.expand;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author gumingchen
 */
public class ServiceImplX<M extends BaseMapperX<T>, T> extends ServiceImpl<M, T> implements IServiceX<T> {

}