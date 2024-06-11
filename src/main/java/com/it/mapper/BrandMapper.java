package com.it.mapper;

import com.it.pojo.Brand;

import java.util.List;

public interface BrandMapper {

    List<Brand> selectAll();

    Brand selectById(int id);
}
