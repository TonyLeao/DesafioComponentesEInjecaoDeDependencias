package com.devsuperior.desafiocompinjdep.services;

import com.devsuperior.desafiocompinjdep.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    ShippingService shippingService;

    public double total(Order order) {
        return order.getBasic()
                - order.getBasic() * (order.getDiscount() / 100.0)
                + shippingService.shipment(order);
    }
}
