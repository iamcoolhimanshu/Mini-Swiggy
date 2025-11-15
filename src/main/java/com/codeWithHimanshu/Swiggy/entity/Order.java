package com.codeWithHimanshu.Swiggy.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @Column(length = 800)
    private String items;

    private double totalAmount;

    private String status;
}
