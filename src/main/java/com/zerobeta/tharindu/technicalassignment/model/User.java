package com.zerobeta.tharindu.technicalassignment.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@Table(name="users")
public class User {
    @Id
    @GeneratedValue()
    private Long id;
    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @OneToMany(mappedBy = "orders")
    private Set<Order> orders;
}
