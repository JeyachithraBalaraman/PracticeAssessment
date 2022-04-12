package com.MainStock;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StockLinkedList sll = new StockLinkedList();
		double value;
		boolean yn;
		System.out.println("Stockers");
		System.out.println("Enter number of Companies");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Enter value of " + (i + 1) + " company Stock");
			value = sc.nextDouble();
			System.out.println("Company Stock Raise/Fall enter true/false ");
			yn = sc.nextBoolean();
			sll.insertValues(value, yn);
		} // for
		System.out.println("Details entered");
		sll.displayLinkedList();
		int option = 0;
		do {
			System.out.println("OPERATIONS");
			System.out.println("1.Display the companies stock prices in ascending Order");
			System.out.println("2.Display the companies stock prices in decending Order");
			System.out.println("3.Display the total no. of companies for which stock prices rose today");
			System.out.println("4.Display the total no. of companies for which stock prices declined today");
			System.out.println("5.Search for specific stock price- present or not");
			System.out.println("6.Exit");
			System.out.println("Select operation to be performed- 1 to 6");
			option = sc.nextInt();
			switch (option) {
			case 1:
				Node h = sll.getHead();
				Node sortll = sll.mergeSort(h);
				System.out.println("Companies Stock Prices in Ascending order");
				sll.displayLinkedList(sortll);
				break;
			case 2:
				Node h1=sll.getHead();
				Node sortdl=sll.mergeSortDecending(h1);
				System.out.println("Companies Stock Prices ");
				sll.displayLinkedList(sortdl);
				break;
			case 3:
				Node h2=sll.getHead();
				int rose=0;
				for(Node temp=h2;temp!=null;temp=temp.nextNode) {
					if(temp.yn==true)
						rose+=1;
				}
				System.out.println("Number of companies for which StockPrices rose today is :"+rose);
				break;
			case 4:
				Node h3=sll.getHead();
				int decline=0;
				for(Node temp=h3;temp!=null;temp=temp.nextNode) {
					if(temp.yn==false)
						decline+=1;
				}
				System.out.println("Number of companies for which StockPrices declined today is :"+decline);
				break;
			case 5:
				Node h4 = sll.getHead();
				Node sortedLL = sll.mergeSort(h4);
				System.out.println("Enter Value to search for ");
			    double s=sc.nextDouble();
			    
			    if (sll.binarySearch(sortedLL, s)== null)
			    	System.out.println("Value not present");
			    else
			    	System.out.println("Value Present");
			    	
			    break;
			case 6:
			break;
			    
			}//switch
			
		} while (option != 0);
		sc.close();
	}// main
}// class
