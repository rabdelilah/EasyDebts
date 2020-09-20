package com.kata.java.EasyDebts.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.kata.java.EasyDebts.entities.Dept;


public class PaymentHistory {
	private List<Dept> paymentHistories = new ArrayList<>();
	
	public List<String> loadPersons() {
		return Arrays.asList(new String[] {"Alice", "Bob", "Claire", "David"});
	}
	
	public void registerPayment(double amount, String creditor, List<String> debtors) {
		if(debtors.size() > 0 && amount > 0) {
			debtors.stream().forEach(debtor -> paymentHistories.add(new Dept(creditor, debtor, amount / debtors.size())));
		}
	}
	
	public List<Dept> computDebtsByDebtor(String debtor) {
		List<Dept> depts = new ArrayList<>();
		loadPersons().stream().filter(item -> !item.equals(debtor)).forEach(creditor -> {
			double credit = paymentHistories.stream().filter(item -> item.getCreditor().equals(creditor) && item.getDebtor().equals(debtor)).mapToDouble(payement -> payement.getAmount()).sum();
			double debt = paymentHistories.stream().filter(item -> item.getDebtor().equals(creditor) && item.getCreditor().equals(debtor)).mapToDouble(payement -> payement.getAmount()).sum();
			double amount = credit - debt;
			if(amount > 0 ) {
				depts.add(new Dept(creditor, debtor, amount));
			}
		});
		return depts;
	}
	
	public List<Dept> balanceDebts(){
		List<Dept> depts = new ArrayList<>();
		loadPersons().stream().forEach(person -> depts.addAll(computDebtsByDebtor(person)));
		return depts;
	}
	
	public void printBalancedDebts() {
		loadPersons().stream().forEach(person -> {
			List<Dept> depts = computDebtsByDebtor(person);
			if(depts.size() == 0 ) {
				System.out.println(person + " has no debts.");
			} else {
				depts.stream().forEach(i -> {
					System.out.println(i.getDebtor() + " owes " + i.getAmount() + " € to " + i.getCreditor());
				});
			}
		});
	}
	
}
