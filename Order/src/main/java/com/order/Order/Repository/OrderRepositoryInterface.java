package com.order.Order.Repository;

import com.order.Order.Model.OrderModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepositoryInterface extends CrudRepository<OrderModel, Long> {

    List<OrderModel> findByUserId(String userId);
}
