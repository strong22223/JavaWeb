package com.Strong.mapper;

import com.Strong.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {
    /**
     * !.注解,简单查询
     * 查询所有数据
     *
     * @return
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    /**
     * 插入数据
     *
     * @param brand
     */
    @Insert("Insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    @ResultMap("brandResultMap")
    void addBrand(Brand brand);

    /**
     * 根据id查询
     *
     * @param id
     */
    @Select("select * from tb_brand where id =#{id}")
    @ResultMap("brandResultMap")
    Brand selectById(int id);

    /**
     *更新
     * @param brand
     */
    @Update("update tb_brand set brand_name=#{brandName},company_name=#{companyName},ordered=#{ordered},description=#{description},status=#{status} where id=#{id}")
    void update(Brand brand);


    /**
     * 删除数据,依据id
     * @param id
     */
    @Delete("delete from tb_brand where id =#{id}")
    void deleteById(int id);

}