package com.kevin.mybatis.builder;


import com.kevin.mybatis.dao.UserMapper;
import com.kevin.mybatis.entity.User;
import com.kevin.mybatis.entity.UserExample;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Properties;

/**
 *  构建器
 */
public class MybatisBuilder {

    private static ResourceLoader resourceLoader = null;

    private static SqlSession sqlSession = null;

    static {
        resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("config/mybatis-config.xml");

        EncodedResource encodedResource = new EncodedResource(resource, "utf-8");
        try {
            Reader reader = encodedResource.getReader();

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "dev", new Properties());

            sqlSession = sqlSessionFactory.openSession();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  初始化一个{@link SqlSession}
     * @return 实例
     */
    public SqlSession build() {
        return sqlSession;
    }

    public static void main(String[] args) {
        SqlSession build = new MybatisBuilder().build();

        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(1);

        List<User> users = build.getMapper(UserMapper.class).selectByExample(userExample);
        if (users != null && !users.isEmpty()) {
            System.out.println(users.get(0));
        }

    }
}
