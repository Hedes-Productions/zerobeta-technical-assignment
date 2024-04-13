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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "f_user_id", referencedColumnName = "user_id")
    private Set<Order> orders;
}
