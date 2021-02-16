package ADA;

import java.util.Random;

public class Exp1 {
	
	// selection sort
	public void selectionSort(int[] arr) {
			
		int temp,min_index;
			for(int i=0;i<arr.length-1;i++)
			{
				//for each i,we will find the smallest element till the end of arr
				min_index=i;
				for(int j=i+1;j<arr.length;j++)
				{
					if(arr[min_index]>arr[j])
					{
						min_index=j;
					}
				}
				//after this loop we will find the index of min element
				//Swap the elements
				temp=arr[i];
				arr[i]=arr[min_index];
				arr[min_index]=temp;
			}
			
	}
	
	// bubble sort
	public void bubbleSort(int[] arr) {
		
		int n=arr.length;
		for(int i=0;i<n-1;i++)
		{
			for(int j=0;j<n-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		
	}
	
	// insertion sort
	public void insertionSort(int[] arr) {
		
		int size=arr.length;
		for(int step=1;step<size;step++)
		{
			int key=arr[step];
			int j=step-1;
			// Compare key with each element on the left of it until an element smaller than
			//it is found
			//For descending order, change key<arr[j] to key>arr[j]
			while(j>=0 && key<arr[j])
			{
				arr[j+1]=arr[j];
				j--;
			}
			//Place key at after the element just smaller than it
			arr[j+1]=key;
		}
	}

	
	// main program
	public static void main(String[] args) {
		
		Random rd = new Random(); // creating Random object
	    int[] array1 = new int[10000];
	    int[] array2 = new int[10000];
	    int[] array3 = new int[10000];
	    
	    
	    
	    for(int i = 0; i < 10000; i++) {
	    	int random = rd.nextInt()/1000000;
	    	if((random) > 0) {
	    		array1[i] = random;
	    		array2[i] = random;
	    		array3[i] = random;
	    	}
	    	else {
	    		i--;
	    	}
	    }
	    
	    
	    Exp1 e = new Exp1();
	    
	    long startTime1 = System.currentTimeMillis();
	    // call to selection sort
	    e.selectionSort(array1);
	    long endTime1   = System.currentTimeMillis();
	    
	    // calculating time
	    float totalTime1 = (endTime1 - startTime1);
	    // print time
	    System.out.println("Time taken by selection sort = "+totalTime1+" milliseconds");
	    
	    
	    long startTime2 = System.currentTimeMillis();
	    // call to Bubble sort
 	    e.bubbleSort(array2);
	    long endTime2   = System.currentTimeMillis();
	    // calculating time
	    float totalTime2 = (endTime2 - startTime2);
	    // print time
	    System.out.println("Time taken by bubble sort = "+totalTime2+" milliseconds");
	    
	    
	    long startTime3 = System.currentTimeMillis();
	    // call to insertion sort
 	    e.insertionSort(array3);
	    long endTime3   = System.currentTimeMillis();
	    // calculating time
	    float totalTime3 = (endTime3 - startTime3);
	    // print time
	    System.out.println("Time taken by insertion sort = "+totalTime3+" milliseconds");
	    
	    
	}
}
