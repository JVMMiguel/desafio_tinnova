package com.tinnova.task4;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Task4Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Task4Application.class, args);

		Scanner s = new Scanner(System.in);

		System.out.print("\nDigite um número: ");

		int number = s.nextInt();
		s.close();

		int sum = 0;

		for (int i = 1; i < number; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		
		System.out.print("\n");
		System.out.println("A soma dos múltiplos de 3 e 5 menores que " + number + " é: " + sum);
	}

}
