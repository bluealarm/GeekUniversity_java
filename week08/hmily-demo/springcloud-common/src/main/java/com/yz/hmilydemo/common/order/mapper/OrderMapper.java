package com.yz.hmilydemo.common.order.mapper;

import com.yz.hmilydemo.common.order.entity.Order;

public interface OrderMapper {

    int save(Order order);

    int update(Order order);
}
