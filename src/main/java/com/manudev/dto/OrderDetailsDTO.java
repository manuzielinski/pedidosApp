package com.manudev.dto;

import com.manudev.entity.OrderDetails;
import com.manudev.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailsDTO {

    private Long productId;
    private int quantity;
}