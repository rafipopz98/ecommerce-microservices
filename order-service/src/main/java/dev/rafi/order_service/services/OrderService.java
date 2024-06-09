package dev.rafi.order_service.services;

import dev.rafi.order_service.dto.OderRequest;
import dev.rafi.order_service.dto.OrderLineItemDTO;
import dev.rafi.order_service.model.OrderLineItem;
import dev.rafi.order_service.model.OrderModel;
import dev.rafi.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public void placeOrder(OderRequest orderRequest) {
        OrderModel order = new OrderModel();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItem> orderLineItemList = orderRequest.getOrderLineItemDTOList()
                .stream()
                .map(this::mapToDto).toList();

        order.setOrderLineItemsList(orderLineItemList);
        orderRepository.save(order);
    }

    private OrderLineItem mapToDto(OrderLineItemDTO orderLineItemDTO) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setPrice(orderLineItemDTO.getPrice());
        orderLineItem.setQuantity(orderLineItemDTO.getQuantity());
        orderLineItem.setSkuCode(orderLineItemDTO.getSkuCode());
        return orderLineItem;
    }
}
