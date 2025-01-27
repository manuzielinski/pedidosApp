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
public class PaymentMeans {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentMeansId;

    @Column(nullable = false)
    private PaymentTypes type;

    @Column(nullable = false)
    private String details;
}
