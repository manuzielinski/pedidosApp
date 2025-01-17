package com.manudev.dto;
import java.util.List;
import com.manudev.entity.OrderDetails;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private Long productId;
    private String name;
    private String description;
    private int price;
    private int stock;
    private boolean active;
    private List<OrderDetails> detailsList;
}
