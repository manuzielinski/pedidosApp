package com.manudev.service.impl;

import com.manudev.dto.OrderDTO;
import com.manudev.entity.Order;
import com.manudev.mappers.OrderMapper;
import com.manudev.repository.OrderRepository;
import com.manudev.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;


    @Override
    public List<OrderDTO> listAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapper::orderToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        return orderMapper.orderToDTO(order);
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = orderMapper.dtoToOrder(orderDTO);
        orderRepository.save(order);
        return orderMapper.orderToDTO(order);
    }

    @Override
    public OrderDTO updateOrder(Long orderId, OrderDTO orderDTO) {
        // first, we gonna find the old order
        Order existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        // second, locate the new order
        Order updatedOrder = orderMapper.dtoToOrder(orderDTO);
        updatedOrder.setOrderId(existingOrder.getOrderId());
        updatedOrder = orderRepository.save(updatedOrder);
        return orderMapper.orderToDTO(updatedOrder);
    }

    @Override
    public void deleteOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        order.setActive(false);
        orderRepository.save(order);
    }
}
