package com.loman.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/19.
 */

public interface IBaseDao {

    /**
     * 保存对象
     * @param str
     * @param obj
     * @return
     */
    Object save(String str, Object obj);

    /**
     * 修改对象
     * @param str
     * @param obj
     * @return
     */
    Object update(String str, Object obj);

    /**
     * 批量更新
     * @param str
     * @param objs
     */
    void batchUpdate(String str, List objs);

    /**
     * 删除对象
     * @param str
     * @param obj
     * @return
     */
    Object delete(String str, Object obj);

    /**
     * 查找对象
     * @param str
     * @param obj
     * @return
     */
    Object findForObject(String str, Object obj);

    /**
     * 查找对象封装成Map
     * @param sql
     * @param obj
     * @param key
     * @param value
     * @return
     */
    Object findForMap(String sql, Object obj, String key, String value);

    /**
     * 查找list
     * @param sql
     * @param obj
     * @return
     */
    Object findForList(String sql,Object obj);

}
