package com.zerobeta.tharindu.technicalassignment;

import com.zerobeta.tharindu.technicalassignment.model.Order;
import com.zerobeta.tharindu.technicalassignment.model.User;
import com.zerobeta.tharindu.technicalassignment.repository.OrderRepository;
import com.zerobeta.tharindu.technicalassignment.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TechnicalAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnicalAssignmentApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserRepository users, OrderRepository orders){
		return args -> {
			users.save(User.builder()
					.email("tharindu@gmail.com")
					.password("password")
					.firstName("tharindu")
					.lastName("gimras")
					.build()
			);

			orders.save(Order.builder()
					.item_name("tharindu")
					.quantity(5)
					.address("70/4,Web,Nit")
					.status("fine")
					.build()
			);
		};
	}
}
