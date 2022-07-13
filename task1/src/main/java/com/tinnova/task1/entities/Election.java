package com.tinnova.task1.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Election {
	private double totalVoters;
	private double validVotes;
	private double blankVotes;
	private double nullVotes;

	public double calculateValidVotes() {
		return (this.getValidVotes()/this.getTotalVoters()) * 100;
	}

	public double calculateBlankVotes() {
		return (this.getBlankVotes()/this.getTotalVoters()) * 100;
	}

	public double calculateNullVotes() {
		return (this.getNullVotes()/this.getTotalVoters()) * 100;
	}
}
