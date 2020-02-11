package com.ltt.springcloud.dao;

import com.ltt.springcloud.entities.Dept;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: xns
 * @Date: 20-1-14 下午1:34
 */
@Mapper
public interface DeptDao {
    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}
