package com.xns.springcloud.testservice;

import com.xns.springcloud.dao.DeptDao;
import com.xns.springcloud.entities.Dept;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: xns
 * @Date: 20-1-14 下午8:59
 */
@SpringBootTest
public class testDao {

    @Autowired
    DeptDao deptDao;

    @Test
    public void testDept(){
        List<Dept> depts= deptDao.findAll();
        for (int i = 0; i <depts.size(); i++) {
            System.out.print(depts.get(i).getDeptno()+depts.get(i).getDb_source()+" ");
        }
    }
}
