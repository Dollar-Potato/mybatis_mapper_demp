package com.it.test;

import com.it.mapper.BrandMapper;
import com.it.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    public void testSelectAll() throws IOException {

        //接收参数
        int id = 1;

        //1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();


        //3.获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        Brand brand = brandMapper.selectById(id);

        System.out.println(brand);


        //4.释放资源
        sqlSession.close();
    }
}
