package com.xns.springcloud.service;


import com.xns.springcloud.entities.Dept;

import java.util.List;

/**
 * @Author: xns
 * @Date: 20-1-14 下午7:34
 */
public interface DeptService {
    public boolean add(Dept dept);

    public Dept get(Long id);

    public List<Dept> list();
}
