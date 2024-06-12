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
import java.util.HashMap;
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


    @Test
    public void selectByCondition() throws IOException {

        //接收参数
        int status =1;
        String companyName = "华为";
        String brandName = "华为";

        //处理参数（模糊查询）
        companyName  = "%" + companyName + "%";
        brandName  = "%" + brandName + "%";

        //封装对象
       /* Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);*/

        HashMap map = new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);

        //1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();


        //3.获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        /*散装参数
        List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);*/

        /*对象参数
         List<Brand> brands = brandMapper.selectByCondition(brand);
        * */

        //集合参数
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);


        //4.释放资源
        sqlSession.close();
    }
}
