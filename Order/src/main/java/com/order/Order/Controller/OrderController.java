package com.order.Order.Controller;

import com.google.common.collect.Lists;
import com.order.Order.DTO.OrderDto;
import com.order.Order.Model.OrderModel;
import com.order.Order.Service.OrderInterface;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.persistence.criteria.Order;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderInterface orderInterface;

    @RequestMapping("place-order")
    public String placeOrder(@RequestParam String emailUser, String productId, String userId, String merchantId, double cost) throws AddressException {
        orderInterface.addProductToCart(new OrderDto(productId, userId, merchantId,cost));
//        final Email email = DefaultEmail.builder()
//                .from(new InternetAddress("Achint"))
//                .to((Collection<InternetAddress>) new InternetAddress(emailUser))
//                .subject("Testing")
//                .body("Succes")
//                .encoding("UTF-8").build();
        return "Email Sent";
    }

    @RequestMapping("order-history")
    public List<OrderModel> getCartHistory(@RequestParam String userId){
        return orderInterface.getCartHistory(userId);
    }

}
