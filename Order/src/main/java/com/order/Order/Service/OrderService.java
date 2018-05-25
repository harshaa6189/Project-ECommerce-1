package com.order.Order.Service;

import com.order.Order.DTO.OrderDto;
import com.order.Order.Model.OrderModel;
import com.order.Order.Repository.OrderRepositoryInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService implements  OrderInterface{

    @Autowired
    private OrderRepositoryInterface orderRepositoryInterface;

    @Override
    public void addProductToCart(OrderDto orderDto) {
        OrderModel order = new OrderModel();
        BeanUtils.copyProperties(orderDto, order);
        orderRepositoryInterface.save(order);
    }

    @Override
    public List<OrderModel> getCartHistory(String userId) {
        List<OrderModel> order = orderRepositoryInterface.findByUserId(userId);
        return order;
    }
}
