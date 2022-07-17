package com.Strong.service;

import com.Strong.pojo.Brand;

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

}
