package com.Strong.service;

import com.Strong.mapper.UserMapper;
import com.Strong.pojo.User;
import com.Strong.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    private SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password) {
        //1.获取sqlSession
        SqlSession sqlSession = factory.openSession();
        //2.获取BrandMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //3.调用方法
        User user = mapper.login(username, password);

        sqlSession.close();

        //关闭资源
        return user;
    }


    public boolean add(User user) {
        //1.获取sqlSession
        SqlSession sqlSession = factory.openSession();
        //2.获取BrandMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //3.调用方法
        User u = mapper.selectByUsername(user.getUsername());
        if (u == null) {
            //可以添加
            mapper.addUser(user);
            sqlSession.commit();
        }
        //关闭资源
        sqlSession.close();
        return u == null;
    }

}
