package com.manudev.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderDetailsId;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int subtotal;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false) // Define la clave foránea correctamente
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false) // Cambia @Column por @JoinColumn aquí
    private Product product;
}
