package com.manudev.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int subtotal;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderDetails orderDetails;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
