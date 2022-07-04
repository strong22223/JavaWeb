package com.Strong.service;

import com.Strong.mapper.BrandMapper;
import com.Strong.pojo.Brand;
import com.Strong.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    private SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 调用方法来获取所有的数据
     *
     * @return
     */
    public List<Brand> selectAll() {
        //调用BrandMapper.selectAll()的方法
        //1.获取sqlSession,使用工具类
        SqlSession sqlSession = factory.openSession();
        //2.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //3.调用方法
        List<Brand> brands = mapper.selectAll();
        //4.关闭资源
        sqlSession.close();
        return brands;
    }

    public void addBrand(Brand brand) {
        //1.获取sqlSession
        SqlSession sqlSession = factory.openSession();
        //2.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //3.调用方法
        mapper.addBrand(brand);
        //提交事物
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    public Brand selectById(int id) {
        //1.获取sqlSession
        SqlSession sqlSession = factory.openSession();
        //2.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //3.调用方法
        Brand brand = mapper.selectById(id);

        //提交事物
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
        return brand;
    }

    /**
     * 修改
     *
     * @param brand
     */
    public void update(Brand brand) {
        //1.获取sqlSession
        SqlSession sqlSession = factory.openSession();
        //2.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //3.调用方法
        mapper.update(brand);
        //提交事物
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }

    public void deleteById(int id) {
        //1.获取sqlSession
        SqlSession sqlSession = factory.openSession();
        //2.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //3.调用方法
        mapper.deleteById(id);

        sqlSession.commit();

        sqlSession.close();
    }


}
