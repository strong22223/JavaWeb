package com.Strong.mapper;

import com.Strong.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    /**
     * 根据用户名和密码来登录
     *
     * @param username
     * @param password
     * @return
     */
    @Select("select * from tb_user where username=#{username} and password =#{password}")
    @ResultMap("userResultMap")
    User login(@Param("username") String username, @Param("password") String password);


    /**
     * 注册
     *
     * @param username
     * @return
     */
    @Select("Select * from tb_user where username=#{username}")
    User selectByUsername(String username);

    /**
     * @param user
     */
    @Insert("insert into tb_user values (null,#{username},#{password})")
    void addUser(User user);

}
