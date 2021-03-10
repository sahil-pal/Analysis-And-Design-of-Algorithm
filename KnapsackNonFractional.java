package ADA;

import java.util.Random;
import java.util.Scanner;

import ADA.Exp4.ItemValue;

public class KnapsackNonFractional {

	public static double getMaxProfit(int[] wt, int[] profit, int capacity, int n) {
	
		double totalProfit=0d;
		
		Item[] ival = new Item[n];
		
		for(int i =0; i < n;i++) {
			ival[i] = new Item(wt[i],profit[i]);
		}
		
		for(int i = 0 ; i < n ;i++) {
			Item value = ival[i];
			int hole = i-1;
			while(hole >= 0 && ival[hole].profit < value.profit) {
				ival[hole+1] = ival[hole];
				hole = hole - 1;
			}
			ival[hole+1] = value;
		}
		
		System.out.println();
		for(int i = 0 ; i < n; i++) {
			System.out.println(ival[i].profit+"   | wt : "+ival[i].wt);
		}
		

		for(int i = 0; i< n; i++) {
			if(ival[i].wt <= capacity && capacity >= 0) {
				System.out.println("selected : "+(i+1));
				capacity -= ival[i].wt;
				totalProfit += ival[i].profit;
			}
			else {
				System.out.println("skipping : "+(i+1));
			}
		}
		
		return totalProfit;
	}
	
	static class Item{
		public int wt=0;
		public int profit=0;
		Item(int wt, int profit){
			this.wt = wt;
			this.profit = profit;
		
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements : ");
		int n = sc.nextInt();
		
		System.out.println("Enter the capacity of knapsack : ");
		int capacity  = sc.nextInt();
		
		Random rd = new Random();
		
		int[] wt = new int[n];
		int[] profit = new int[n];
		
		for(int i = 0;i < n;i++) {
			int num1 = rd.nextInt(100);
			int num2 = rd.nextInt(1000);
			if(num1 > 0 && num2 > 0) {
				wt[i] = num1;
				profit[i] = num2;
			}
			else {
				i--;
			}
		}
		
		double maxProfit = getMaxProfit(wt,profit,capacity,n);
		
		System.out.println();
		for(int i = 0; i < n ;i++) {
			System.out.println("Wt : "+wt[i]+" | value : "+profit[i]+" ");
		}
	
		System.out.println();
		System.out.println("The maximum profit is : "+maxProfit);
	
	}
}
