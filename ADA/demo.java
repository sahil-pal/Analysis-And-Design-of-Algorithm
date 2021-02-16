package ADA;

import java.util.Arrays;
import java.util.Random;

public class demo {
	
	int recursive_call;
	int quickSort(int arr[], int low, int high)
	{
		
		if(low<high)
		{
			//partition the array around pi=>partitioning index and return pi
			int pi = Partition(arr,low,high);
			// sort each partition recursively 
			quickSort(arr,low,pi-1);
			quickSort(arr,pi+1,high);
			recursive_call = recursive_call + 1;
		}
		
		return recursive_call;
	}

	//selects last element as pivot, pi using which array is partitioned. 
	int Partition(int arr[],int low,int high)
	{
		int pi=arr[high];
		int i=low-1; // smaller element index  
		for(int j=low;j<high;j++)
		{
			// check if current element is less than or equal to pi
			if(arr[j]<pi)
			{
				i++;
				// swap arr[i] and arr[j] 
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		// swap arr[i+1] and arr[high] (or pi) 
		int temp1=arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp1;
		return i+1;
	}

	
	// main method
	public static void main(String args[]) {
		
		Random rd = new Random(); // creating Random object
	    int[] array1 = { 2,421,5,1,8,3,9,6,4,7};
	    int[] array2 = { 1,2,3,4,5,6,7,8,9,10};
	    int[] array3 = { 10,9,8,7,6,5,4,3,2,1};
	    int[] array4 = { 7,7,7,7,7,7,7,7,7,7};
	    
	    
//	    for(int i = 0; i < 1000; i++) {
//	    	int random = rd.nextInt()/1000000;
//	    	if((random) > 0) {
//	    		array1[i] = random;
//	    		array2[i] = random;
//	    	}
//	    	else {
//	    		i--;
//	    	}
//	    }
//	    
//	    
//	    // applying conditions 
//	    Arrays.sort(array2);
//	    
//	    int j = 999;
//	    for(int i = 0; i < 1000; i++) {
//	    	array3[i] = array2[j];
//	    	j--;
//	    	array4[i] = 7;
//	    }
	    
	    
	    
	    
	    Exp3 e = new Exp3();
	    
	    long startTime1 = System.currentTimeMillis();
	    // call to quick sort
	    e.recursive_call=0;
	    int count1 = e.quickSort(array1,0,9);
	    long endTime1   = System.currentTimeMillis();
	    
	    // calculating time
	    float totalTime1 = (endTime1 - startTime1);
	    // print time
	    System.out.println("Time taken by quick sort = "+totalTime1+" milliseconds");
	    System.out.println("Number of recursive calls = "+count1);
	    for(int i = 0; i < 10; i++) {
	    	System.out.println(array1[i]);
	    }
	    System.out.println();
	    
	    
	    long startTime2 = System.currentTimeMillis();
	    // call to quick sort
	    e.recursive_call=0;
 	    int count2 = e.quickSort(array2,0,9);
	    long endTime2   = System.currentTimeMillis();
	    // calculating time
	    float totalTime2 = (endTime2 - startTime2);
	    // print time
	    System.out.println("Time taken by quick sort when array in assending order = "+totalTime2+" milliseconds");
	    System.out.println("Number of recursive calls = "+count1);
	    System.out.println();
	    
	    
	    long startTime3 = System.currentTimeMillis();
	    // call to quick sort
	    e.recursive_call=0;
	    int count3 = e.quickSort(array3,0,9);
	    long endTime3   = System.currentTimeMillis();
	    
	    // calculating time
	    float totalTime3 = (endTime3 - startTime3);
	    // print time
	    System.out.println("Time taken by quick sort when array in decending order = "+totalTime3+" milliseconds");
	    System.out.println("Number of recursive calls = "+count3);
	    System.out.println();
	    
	    
	    long startTime4 = System.currentTimeMillis();
	    // call to quick sort
	    e.recursive_call=0;
	    int count4 = e.quickSort(array4,0,9);
	    long endTime4   = System.currentTimeMillis();
	    
	    // calculating time
	    float totalTime4 = (endTime4 - startTime4);
	    // print time
	    System.out.println("Time taken by quick sort when array is equal = "+totalTime4+" milliseconds");
	    System.out.println("Number of recursive calls = "+count4);
	    System.out.println();
		
		
		
	}
}
