package ADA;
import java.util.*;

public class JobScheduling {

	public static int getMaxProfit(int[] p, int[] d,int available) {
		
		// declaring the total profit variable
		int totalProfit=0;
		
		// array to track the available schedule
		int[] schedule = new int[available+1];
		
		// initially all slots are vacant --> initialize the array as 0
		for(int i = 0; i < available+1; i++) {
			schedule[i] = 0;
		}
		
		// creating a array of the Job type ,so that while sorting the profit values we can track the job deadline too
		Job[] sequence = new Job[p.length];
		
		// initializing the Job type array
		for(int i =0; i < p.length;i++) {
			sequence[i] = new Job(p[i],d[i]);
		}
		
		// Applying insertion sort to sort the profit in decreasing order (Time complexity : O(n^2) )
		for(int i=0;i < p.length ;i++) {
			Job value = sequence[i];
			int hole = i-1;
			while(hole >= 0 && sequence[hole].profit < value.profit) {
				sequence[hole+1] = sequence[hole];
				hole = hole - 1;
			}
			sequence[hole+1] = value;
		}
		
		// printing the sorted result for verification
		System.out.println("After sort : ");
		for(int i =0; i < p.length;i++) {
			System.out.println("Profit : "+sequence[i].profit+" | deadline : "+sequence[i].deadline);
		}
		
		
	
	
		for(int i = 0; i < p.length; i++ ) {
			System.out.println();
			int currProfit = sequence[i].profit;
			int currdeadline = sequence[i].deadline;
			System.out.println("In the loop : profit = "+currProfit+" and deadline = "+currdeadline);
			while(currdeadline > 0 ) {
				if(schedule[currdeadline] == 0) {
					schedule[currdeadline] = 1;
					totalProfit += currProfit;
					System.out.println("selected at slot : "+currdeadline+" in the schedule");
					break;
				}
				else {
					System.out.println("Not selected at "+currdeadline);
					currdeadline--;
				}
				
			}
		}
		
		return totalProfit;
	}
	
	// Job data structure
	static class Job{
		private int profit=0;
		private int deadline=0;
		Job(int profit, int deadline){
			this.profit=profit;
			this.deadline=deadline;
		}
	}
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		// entering the total number of jobs available to do
		System.out.println("Enter the number of jobs : ");
		int n = sc.nextInt();
		
		// entering the job profit with their deadline
		System.out.println("Enter the jobs Profit with deadline : ");
		int[] profit = new int[n];
		int[] deadline = new int[n];
		for(int i =0; i < n; i++) {
			profit[i] = sc.nextInt();
			deadline[i] = sc.nextInt();
		}
		
		// entering the number of slots available for the machine to work
		System.out.println("Enter the number of available slots : ");
		int capable = sc.nextInt();
		
		// printing the input details
		System.out.println("Initiallly : ");
		for(int i =0; i < n;i++) {
			System.out.println("Profit : "+profit[i]+" | deadline : "+deadline[i]);
		}
		
		// calling the function calculating the max profit from job completion
		int maxProfit = getMaxProfit(profit,deadline,capable);
		
		// printing the resultant profit
		System.out.println();
		System.out.println("Max profit from job is  : "+maxProfit);
	}
}
