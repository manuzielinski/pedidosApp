package com.manudev.dto;
import java.time.LocalDate;
import java.util.List;
import com.manudev.entity.OrderDetails;
import com.manudev.entity.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {

    private Long orderId;
    private LocalDate orderDate;
    private String description;
    private boolean active;
    private OrderStatus status;
    private List<OrderDetails> details;
}
