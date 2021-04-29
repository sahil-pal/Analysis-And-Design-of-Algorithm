package Sorting;

import java.util.Scanner;

public class Insertion_sort {

	public void Isort(int[] array, int n) {
		
		for(int i = 1; i < n; i++) {
			int value = array[i];
			int hole = i-1;
			while(hole >= 0 && array[hole] > value) {
				array[hole+1] = array[hole];
				hole = hole - 1;
			}
			array[hole+1] = value;
		}
	
		for(int i = 0; i < n; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] arr = {6,4,5,3,1,2};
		
		Insertion_sort i1 = new Insertion_sort();
		
		i1.Isort(arr, arr.length);
	
	}

}
