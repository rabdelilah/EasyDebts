package com.kata.java.EasyDebts;

import java.util.Arrays;

import com.kata.java.EasyDebts.services.PaymentHistory;

public class App {

	public static void main(String[] args) {
		PaymentHistory payment_history = new PaymentHistory();
		payment_history.registerPayment(15, "Alice",Arrays.asList(new String[] {"Alice", "Bob", "Claire"}));
		payment_history.registerPayment(8, "David", Arrays.asList(new String[] {"Alice", "Claire"}));
		payment_history.registerPayment(32, "Bob", Arrays.asList(new String[] {"Alice", "Bob", "Claire", "David"}));
		payment_history.printBalancedDebts();
		
	}

}
