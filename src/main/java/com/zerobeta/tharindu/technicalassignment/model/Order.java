package com.zerobeta.tharindu.technicalassignment.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@Table(name="orders")
public class Order {
    @Id
    @Builder.Default
    @Column(name="order_id")
    private UUID id=UUID.randomUUID() ;
    private String item_name;
    private Integer quantity;
    private String address;
    @Setter
    @Builder.Default
    private String status="NEW";
    @Builder.Default
    private LocalDateTime placementTimestamp=LocalDateTime.now();

}
