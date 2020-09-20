package com.kata.java.EasyDebts;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.kata.java.EasyDebts.entities.Dept;
import com.kata.java.EasyDebts.services.PaymentHistory;


public class AppTest 
{
	
	private PaymentHistory paymentHistory = new PaymentHistory();
    
    @Test
    public void registerPaymentAliceTest()
    {
    	paymentHistory.registerPayment(15, "Alice",Arrays.asList(new String[] {"Alice", "Bob", "Claire"}));
    	List<Dept> l = paymentHistory.balanceDebts();
        assertEquals(getPaymentAliceExpected(), l);
    }
    
    @Test
    public void registerPaymentDavidTest()
    {
    	paymentHistory.registerPayment(8, "David", Arrays.asList(new String[] {"Alice", "Claire"}));
    	List<Dept> l = paymentHistory.balanceDebts();
        assertEquals(getPaymentDavidExpected(), l);
    }
    
    @Test
    public void registerPaymentBobTest()
    {
    	paymentHistory.registerPayment(32, "Bob", Arrays.asList(new String[] {"Alice", "Bob", "Claire", "David"}));
    	List<Dept> l = paymentHistory.balanceDebts();
        assertEquals(getPaymentBobExpected(), l);
    }
    
    @Test
    public void balanceDebtsTest()
    {
    	paymentHistory.registerPayment(15, "Alice",Arrays.asList(new String[] {"Alice", "Bob", "Claire"}));
    	paymentHistory.registerPayment(8, "David", Arrays.asList(new String[] {"Alice", "Claire"}));
    	paymentHistory.registerPayment(32, "Bob", Arrays.asList(new String[] {"Alice", "Bob", "Claire", "David"}));
    	List<Dept> l = paymentHistory.balanceDebts();
        assertEquals(getBalanceDebtsExpected(), l);
    }
    
    
    public List<Dept> getPaymentAliceExpected(){
    	List<Dept> l = new ArrayList<Dept>();
    	l.add(new Dept("Alice", "Bob", 5));
    	l.add(new Dept("Alice", "Claire", 5));
    	return l;
    }
    
    public List<Dept> getPaymentDavidExpected(){
    	List<Dept> l = new ArrayList<Dept>();
    	l.add(new Dept("David", "Alice", 4));
    	l.add(new Dept("David", "Claire", 4));
    	return l;
    }
    
    public List<Dept> getPaymentBobExpected(){
    	List<Dept> l = new ArrayList<Dept>();
    	l.add(new Dept("Bob", "Alice", 8));
    	l.add(new Dept("Bob", "Claire", 8));
    	l.add(new Dept("Bob", "David", 8));
    	return l;
    }

    public List<Dept> getBalanceDebtsExpected(){
    	List<Dept> l = new ArrayList<Dept>();
    	l.add(new Dept("Bob", "Alice", 3));
    	l.add(new Dept("David", "Alice", 4));
    	l.add(new Dept("Alice", "Claire", 5));
    	
    	l.add(new Dept("Bob", "Claire", 8));
    	l.add(new Dept("David", "Claire", 4));
    	l.add(new Dept("Bob", "David", 8));
		
    	return l;
    }
}
