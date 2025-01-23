package com.manudev.mappers;

import com.manudev.dto.OrderDTO;
import com.manudev.entity.Order;
import com.manudev.entity.OrderDetails;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-23T02:04:02-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDTO orderToDTO(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setOrderId( order.getOrderId() );
        orderDTO.setOrderDate( order.getOrderDate() );
        orderDTO.setDescription( order.getDescription() );
        orderDTO.setActive( order.isActive() );
        orderDTO.setStatus( order.getStatus() );
        List<OrderDetails> list = order.getDetails();
        if ( list != null ) {
            orderDTO.setDetails( new ArrayList<OrderDetails>( list ) );
        }

        return orderDTO;
    }

    @Override
    public Order dtoToOrder(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Order.OrderBuilder order = Order.builder();

        order.orderId( orderDTO.getOrderId() );
        order.orderDate( orderDTO.getOrderDate() );
        order.description( orderDTO.getDescription() );
        order.active( orderDTO.isActive() );
        order.status( orderDTO.getStatus() );
        List<OrderDetails> list = orderDTO.getDetails();
        if ( list != null ) {
            order.details( new ArrayList<OrderDetails>( list ) );
        }

        return order.build();
    }
}
