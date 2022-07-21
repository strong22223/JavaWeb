package com.Strong.service.impl;

import com.Strong.mapper.BrandMapper;
import com.Strong.pojo.Brand;
import com.Strong.pojo.PageBean;
import com.Strong.service.BrandService;
import com.Strong.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    private final SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 调用方法来获取所有的数据
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
        //成功的时间提交事物
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }


    /**
     * 根据id查询
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

    @Override
    public void deleteByIds(int[] ids) {
        //1.获取sqlSession
        SqlSession sqlSession = factory.openSession();
        //2.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //3.调用方法
        mapper.deleteByIds(ids);
        //成功的时间提交事物
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }

    /**
     * 分页查询
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageBean<Brand> selectByPageSize(int currentPage, int pageSize) {
        //调用BrandMapper.selectAll()的方法
        //1.获取sqlSession,使用工具类
        SqlSession sqlSession = factory.openSession();
        //2.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //3.调用方法
        List<Brand> brandsByPageSize = mapper.selectByPage((currentPage - 1) * pageSize, pageSize);
        long totalNum = mapper.selectTotalNum();

        //4.封装数据
        PageBean<Brand> brandPageBean = new PageBean<>();
        brandPageBean.setTotalSize(totalNum);
        brandPageBean.setPageSizeDate(brandsByPageSize);
        System.out.println(brandPageBean);
        //4.关闭资源
        sqlSession.close();
        return brandPageBean;
    }

    @Override
    public PageBean<Brand> selectByPageAccordingCondition(int currentPage, int pageSize, Brand brand) {
        //调用BrandMapper.selectAll()的方法
        //1.获取sqlSession,使用工具类
        SqlSession sqlSession = factory.openSession();
        //2.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //3.设置数据
        //查询开始的数据
        int begin = (currentPage - 1) * pageSize;
        //pageSize  size=pageSize

        //模糊查询的设置
        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length() != 0) {
            brand.setBrandName("%" + brandName + "%");
        }

        String companyName = brand.getCompanyName();
        if (companyName != null && companyName.length() != 0) {
            brand.setCompanyName("%" + companyName + "%");
        }


        //3.调用方法
        List<Brand> brandsDates = mapper.selectByPageAccordingCondition(begin, pageSize, brand);
        long totalNum = mapper.selectTotalNumCondition(brand);

        //4.封装数据
        PageBean<Brand> brandPageBean = new PageBean<>();
        brandPageBean.setTotalSize(totalNum);
        brandPageBean.setPageSizeDate(brandsDates);
        System.out.println(brandPageBean);
        //4.关闭资源
        sqlSession.close();
        return brandPageBean;
    }

}
