package dev.rafi.order_service.controller;


import dev.rafi.order_service.dto.OderRequest;
import dev.rafi.order_service.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OderRequest orderRequests) {
        orderService.placeOrder(orderRequests);
        return "Order Placed Successfully";
    }

}
