package com.xns.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: xns
 * @Date: 20-1-14 下午5:14
 */
@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain=true) //链式写法
public class Dept implements Serializable { //Dpet(Entity orm mysql->Dept(table)类表关系映射//必须序列化
    /**
     * 主键
     */
    private Long deptno;

    /**
     * 部门名称
     */
    private String dname;

    /**
     * 来自哪个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同的数据库
     */
    private String db_source;

//    public Dept(String dname){
//        super();
//        this.dname=dname;
//    }

//    public static void main(String[] args){
//        Dept dept = new Dept();
//        dept.setDeptno(11L).setDname("RD").setDb_source("dedeed");
//    }
}
