package ADA;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.lang.*;
 
// Class Test 
// Sahil pal & 19csu265 
// Question - 19 : To find the siblings of a given node in binary tree given in the form of an array.
// But limitation of this program is that, it should be a complete binary tree.
// This can be solved if empty node to form complete binary tree are filled with 0s.

public class Tree
{
     
	 public void getSiblings(int[] arr, int x) {
		    
		 	// find the position of the searched node
		 	int pos =0; 
		    for (int i = 0; i < arr.length; i++) {
		       if(arr[i]==x) {
		    	   pos = i;
		       }
		    }
		   
		    // declare a sibling array to store sibling node data
		    int[] siblings = null;
		    
		    // if searched node is a root node (case:1)
		    if(pos == 0) {
		    	System.out.println("This is root node. No sibling possible.");
		    }
		    else if(pos%2 == 0) {
		    	int start = pos/2;
		    	if(start == 1 || pos == arr.length-1) {
		    		start--;
		    	}
		    	int end = 2*start+2;
		    	
		    	System.out.println("Start : "+(start+1)+" and end : "+end);
		    
		    	siblings = new int[end-start];
		    	int j = 0;
		    
		    	System.out.print("Siblings of "+x+" are : ");
		    	for(int i = start+1 ; i <= end; i++) {
		    		if(arr[i] == x) {
		    		
		    		}
		    		else {
		    			siblings[j] = arr[i];
		    			System.out.println(siblings[j]+" ");
		    			j++;
		    		}
		    	}
		    }
		    else {
		    	int start = pos/2;
		    	if(start > 0 || pos == arr.length-2) {
		    		start++;
		    	}
		    	int end = start*2+2;
		    	
		    	System.out.println("Start : "+(start+1)+" and end : "+end);
				    
				siblings = new int[end-start];
				int j = 0;
				    
				System.out.print("Siblings of "+x+" are : ");
				for(int i = start+1 ; i <= end; i++) {
				    if(arr[i] == x) {
				    	
				    }
				    else {
				    	siblings[j] = arr[i];
				    	System.out.print(siblings[j]+" ");
				    	j++;
				    }
				}
		    	
		    }
	}
	 

	public static void main(String[] args){
		 Tree t2 = new Tree(); 
		 
		 // array representing a binary tree
	     int arr[] = { 0,1,2,4,3,4,6,5 }; 
	     
	     // element whose siblings to be calculated
	     int find = 1;
	     
	     // call the function to calculate the siblings 
	     t2.getSiblings(arr,find);
	     
	}
}
