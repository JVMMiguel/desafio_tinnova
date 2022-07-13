package com.tinnova.task2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Task2Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Task2Application.class, args);
		
		int[] vet = {5, 3, 2, 4, 7, 1, 0, 6};

		System.out.print("\n");
		System.out.print("Vetor Desorganizado: ");
		
		for (int n : vet) {
			System.out.print(n + " ");
		}

		for (int i = 0; i < vet.length-1; i++) { 
			boolean ordered = true; 
			
			for (int j = 0; j < vet.length-1-i; j++) { 

				if (vet[j] > vet[j + 1]) { 
					int aux = vet[j];
					vet[j] = vet[j + 1];
					vet[j + 1] = aux;
					ordered = false;
				}
			}

			if (ordered) 
				break;
		}
		
		System.out.print("\n");
		System.out.print("Vetor Organizado: ");
		
		for (int n : vet) {
			System.out.print(n + " ");
		}

	}

}
