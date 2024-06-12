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

/*
* 多条件查询
* */

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


    /*
    * 单条件查询
    * */
    @Test
    public void selectByConditionSingle() throws IOException {

        //接收参数
        int status =1;
        String companyName = "华为";
        String brandName = "华为";

        //处理参数（模糊查询）
        companyName  = "%" + companyName + "%";
        brandName  = "%" + brandName + "%";

        //封装对象（单条件）
        Brand brand = new Brand();
        brand.setStatus(status);
        //brand.setCompanyName(companyName);
        //brand.setBrandName(brandName);



        //1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();


        //3.获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);



        System.out.println(brands);


        //4.释放资源
        sqlSession.close();
    }

    /*添加*/

    @Test
    public void testAdd() throws IOException {

        //接收参数
        int status =1;
        String companyName = "小米手机";
        String brandName = "波导";
        String description = "手机中的战斗机";
        int ordered = 100;



        //封装对象（单条件）
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);



        //1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //开启自动提交事务，默认是开启事务（false），需要手动提交事务
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);


        //3.获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.add(brand);

        /*
        主键返回
        Integer id = brand.getId();
        System.out.println(id);*/

        //5.提交事务
        sqlSession.commit();


        //4.释放资源
        sqlSession.close();
    }

    /*添加*/

    @Test
    public void testUpdate() throws IOException {

        //接收参数
        int status =50;
        String companyName = "小米手机";
        String brandName = "Mix10";
        String description = "手机中的战斗机";
        int ordered = 200;
        int id = 52;



        //封装对象（单条件）
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setId(id);



        //1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //开启自动提交事务，默认是开启事务（false），需要手动提交事务
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);


        //3.获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.update(brand);

        /*
        主键返回
        Integer id = brand.getId();
        System.out.println(id);*/

        //5.提交事务
        sqlSession.commit();


        //4.释放资源
        sqlSession.close();
    }

    /*根据id删除一条数据*/

    @Test
    public void testDeleteById() throws IOException {

        //接收参数
        int id = 52;

        //1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //开启自动提交事务，默认是开启事务（false），需要手动提交事务
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);


        //3.获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.deleteById(id);

        /*
        主键返回
        Integer id = brand.getId();
        System.out.println(id);*/

        //5.提交事务
        sqlSession.commit();


        //4.释放资源
        sqlSession.close();
    }

    /*批量删除数据*/

    @Test
    public void testDeleteByIds() throws IOException {

        //接收参数
        int[] ids = {51,53};

        //1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //开启自动提交事务，默认是开启事务（false），需要手动提交事务
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);


        //3.获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.deleteByIds(ids);

        /*
        主键返回
        Integer id = brand.getId();
        System.out.println(id);*/

        //5.提交事务
        sqlSession.commit();


        //4.释放资源
        sqlSession.close();
    }
}
