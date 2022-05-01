package com.yz.rpcfx.demo.provider;

import com.yz.rpcfx.demo.api.Order;
import com.yz.rpcfx.demo.api.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order findOrderById(int id) {
        return new Order(id, "Cuijing" + System.currentTimeMillis(), 9.9f);
    }
}
