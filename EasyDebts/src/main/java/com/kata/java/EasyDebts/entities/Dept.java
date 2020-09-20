package com.kata.java.EasyDebts.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dept {
	private String creditor;
	private String debtor;
	private double amount;
}
