package com.tinnova.task3;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Task3Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Task3Application.class, args);
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("\nDigite um número: ");
		
		int number = s.nextInt();
		s.close();

		int nextNumber = 2;
		int factorial = 1;
		
		for (int i = 1; i < number; i++) { 
			factorial = factorial * nextNumber; 
			
			System.out.println(i + " * " + nextNumber + " = " + factorial);
			nextNumber++;
		}
		
		System.out.print("\n");
		System.out.println("O fatorial de " + number + " é: " + factorial);
		
	}

}
