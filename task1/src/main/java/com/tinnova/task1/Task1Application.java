package com.tinnova.task1;

import java.text.DecimalFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tinnova.task1.entities.Election;

@SpringBootApplication
public class Task1Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Task1Application.class, args);
		
		Election election = new Election(1000, 800, 150, 50);
		DecimalFormat df = new DecimalFormat();
		
		System.out.print("\n");
		System.out.println("Dados da eleição: ");
		System.out.print("\n");
		System.out.println("Quantidade de eleitores: " + df.format(election.getTotalVoters()));
		System.out.println("Quantidade de votos válidos: " + df.format(election.getValidVotes()));
		System.out.println("Quantidade de votos em branco: " + df.format(election.getBlankVotes()));
		System.out.println("Quantidade de votos nulos: " + df.format(election.getNullVotes()));
		System.out.print("\n");
		System.out.println("A porcentagem de votos válidos foi de: " + df.format(election.calculateValidVotes()) + "%");
		System.out.println("A porcentagem de votos em branco foi de: " + df.format(election.calculateBlankVotes()) + "%");
		System.out.println("A porcentagem de votos nulos foi de: " + df.format(election.calculateNullVotes()) + "%");
		
	}

}
