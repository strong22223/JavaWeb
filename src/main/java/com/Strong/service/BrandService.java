package com.Strong.service;

import com.Strong.pojo.Brand;
import com.Strong.pojo.PageBean;

import java.util.List;

public interface BrandService {
    /**
     * 查询所有
     *
     * @return
     */
    List<Brand> selectAll();

    /**
     * 添加品牌
     *
     * @param brand
     */
    void addBrand(Brand brand);

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteByIds(int[] ids);

    /**
     * 分页查询,依据前端传输来的,
     * 1:当前页面;2:每页的尺寸
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageBean<Brand> selectByPageSize(int currentPage, int pageSize);

    /**
     * 分页条件查询
     *
     * @param currentPage
     * @param pageSize
     * @param brand
     * @return
     */
    PageBean<Brand> selectByPageAccordingCondition(int currentPage, int pageSize, Brand brand);

}
