package com.yz.test;

import com.yz.dao.JdbcDataSource;
import com.yz.dao.impl.HikariDataSourceImpl;
import com.yz.service.OrderService;
import com.yz.service.impl.OrderServiceImpl;

/**
 * @description TODO
 * author: liquan
 * date: 2020/12/01 00:05
 * version: 1.0
 */
public class HikariTest {

    public static void main(String[] args) {
        JdbcDataSource jdbcDataSource = new HikariDataSourceImpl();
        OrderService orderService = new OrderServiceImpl(jdbcDataSource);

        CreateOrderTest createOrderTest = new CreateOrderTest(orderService,10, 1000);
//        createOrderTest.addOne();
 //       //单线程批量
  //      createOrderTest.addBatch();
        //线程池
        createOrderTest.threadsAddBatch();
    }

}
