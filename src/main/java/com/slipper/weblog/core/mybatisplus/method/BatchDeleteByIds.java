package com.slipper.weblog.core.mybatisplus.method;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;

/**
 * @author gumingchen
 */
public class BatchDeleteByIds extends AbstractMethod {

    protected BatchDeleteByIds() {
        super("deleteBatchIds");
    }

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        return null;
    }
}
