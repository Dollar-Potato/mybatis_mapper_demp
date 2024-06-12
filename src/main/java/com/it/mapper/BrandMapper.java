package com.it.mapper;

import com.it.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    List<Brand> selectAll();

    //根据id查询
    //@Select("select * from tb_brand where id = #{id}")
    Brand selectById(int id);

    /*
    * 多条件查询
    *   参数接收：
    *           1.散装参数：如果方法中有多个参数，需要使用@Param（"Sql参数占位符名称"）
    *           2.对象参数：对象的属性名称要和参数占位符名称一致
    *           3.map集合参数：
    *
    * */

    /*
    1.散装参数
    List<Brand> selectByCondition(@Param("status") int status,@Param("companyName") String companyName,
                                  @Param("brandName")String brandName);*/


   /*
    2.封装对象参数
    List<Brand> selectByCondition(Brand brand);*/

    /*
    3.map集合参数
    */
    List<Brand> selectByCondition(Map map);

    //单条件动态查询
    List<Brand> selectByConditionSingle(Brand brand);

    //添加
    void add(Brand brand);

    //修改
    void update(Brand brand);

    //根据id删除
    void deleteById(int id);

    //批量删除
    //@Param改变key的名称，默认是array
    void deleteByIds(@Param("ids") int[] ids);
}
