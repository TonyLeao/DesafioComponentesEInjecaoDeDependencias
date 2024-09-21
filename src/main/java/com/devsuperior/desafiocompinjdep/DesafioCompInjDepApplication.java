package com.devsuperior.desafiocompinjdep;

import com.devsuperior.desafiocompinjdep.entities.Order;
import com.devsuperior.desafiocompinjdep.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DesafioCompInjDepApplication implements CommandLineRunner {

	@Autowired
	OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(DesafioCompInjDepApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("\nInforme o código do pedido: ");
		int code = sc.nextInt();

		System.out.print("Informe o valor básico do pedido: ");
		double basic = sc.nextDouble();

		System.out.print("Informe a porcentagem de desconto: ");
		double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);

		System.out.println();

		System.out.printf("Pedido código: %d\n", order.getCode());
		System.out.printf("Valor total: R$ %.2f\n", orderService.total(order));

		sc.close();
	}
}
