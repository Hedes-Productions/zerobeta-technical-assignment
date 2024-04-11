package com.zerobeta.tharindu.technicalassignment;

import com.zerobeta.tharindu.technicalassignment.model.Order;
import com.zerobeta.tharindu.technicalassignment.model.User;
import com.zerobeta.tharindu.technicalassignment.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class TechnicalAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnicalAssignmentApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserRepository users, PasswordEncoder passwordEncoder){
		return args -> {
			Set<Order> orders = new HashSet<>();
			orders.add(Order.builder()
					.item_name("dhal")
					.quantity(5)
					.address("70/4,Web,Nit")
					.status("fine")
					.build()
			);
			orders.add(Order.builder()
					.item_name("carrot")
					.quantity(10)
					.address("70/4,Web,Nit")
					.status("fine")
					.build()
			);
			users.save(User.builder()
					.email("tharindu@gmail.com")
					.password(passwordEncoder.encode("password"))
					.firstName("tharindu")
					.lastName("gimras")
					.orders(orders)
					.build()
			);
		};
	}
}
