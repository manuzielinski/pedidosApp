package com.manudev.mappers;

import com.manudev.dto.OrderDTO;
import com.manudev.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper mapper = Mappers.getMapper(OrderMapper.class);

    OrderDTO orderToDTO(Order order);
    Order dtoToOrder(OrderDTO orderDTO);
}
