package com.loman.dao.impl;

import com.loman.dao.IBaseDao;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/4/19.
 */
@Repository
public class BaseDaoImpl implements IBaseDao {

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public Object save(String str, Object obj) {
        return sqlSessionTemplate.insert(str,obj);
    }

    public Object update(String str, Object obj) {
        return sqlSessionTemplate.update(str,obj);
    }

    public void batchUpdate(String str,List objs){
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        //批量执行
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH,false);
        try {
            if (objs != null){
                for (int i = 0,size = objs.size(); i < size ; i++) {
                    sqlSession.update(str,objs.get(i));
                }
                sqlSession.flushStatements();
                sqlSession.commit();
                sqlSession.clearCache();
            }
        } finally {
            sqlSession.close();
        }
    }

    public Object delete(String str, Object obj) {
        return sqlSessionTemplate.delete(str,obj);
    }

    public Object findForObject(String str, Object obj) {
        return sqlSessionTemplate.selectOne(str,obj);
    }

    public Object findForMap(String sql, Object obj, String key, String value) {
        return sqlSessionTemplate.selectMap(sql,obj,key);
    }

    @Override
    public Object findForList(String sql, Object obj) {
        return sqlSessionTemplate.selectList(sql,obj);
    }
}
