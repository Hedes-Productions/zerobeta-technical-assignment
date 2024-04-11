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
    @Column(name="user_id")
    private Long id;
    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "f_user_id", referencedColumnName = "user_id")
    private Set<Order> orders;
}
