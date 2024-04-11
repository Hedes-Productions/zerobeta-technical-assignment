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
    private UUID id=UUID.randomUUID() ;
    @NonNull
    private String item_name;
    @NonNull
    private Integer quantity;
    @NonNull
    private String address;
    @NonNull
    private String status;
    @Builder.Default
    private LocalDateTime placementTimestamp=LocalDateTime.now();
}
