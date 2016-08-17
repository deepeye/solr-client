package org.jzp.solr.client.build;

import org.jzp.solr.client.common.enums.OperateEnum;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 指挥者类
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-06-27
 */
public class Director {

    /**
     * build scope
     */
    public void constructScope(Builder bulider, Field field, Object object, Map<String, Object> map) throws IllegalAccessException {
        bulider.buildScope(field, object, map);
    }

    /**
     * build other
     */
    public void constructOther(Builder bulider, Field field, Object object, OperateEnum operateEnum) throws IllegalAccessException {
        bulider.buildPage(field, object, operateEnum);
    }
}