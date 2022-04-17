package com.yz.test;

import com.yz.dao.JdbcDataSource;
import com.yz.dao.impl.JdbcDataSourceImpl;
import com.yz.service.OrderService;
import com.yz.service.impl.OrderServiceImpl;

/**
 * @description TODO
 * author: liquan
 * date: 2020/12/01 00:05
 * version: 1.0
 */
public class JDBCTest {

    public static void main(String[] args) {
        JdbcDataSource jdbcDataSource = new JdbcDataSourceImpl();
        OrderService orderService = new OrderServiceImpl(jdbcDataSource);
//        //单线程单条插入
//        CreateOrderTest createOrderTest = new CreateOrderTest(orderService,1);
//        createOrderTest.addOne();
          //线程池
        CreateOrderTest createOrderTest = new CreateOrderTest(orderService, 10, 2000);
        //单线程批量
        createOrderTest.addBatch();
        createOrderTest.threadsAddBatch();
    }
}
