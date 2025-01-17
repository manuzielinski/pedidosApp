package com.manudev.service;

import com.manudev.dto.OrderDTO;
import com.manudev.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    public List<OrderDTO> listAllOrders();
    OrderDTO getOrderById(Long Id);
    OrderDTO createOrder(OrderDTO orderDTO);
    OrderDTO updateOrder(Long OrderDTO, OrderDTO orderDTO);
    void deleteOrder(Long orderId);
}
