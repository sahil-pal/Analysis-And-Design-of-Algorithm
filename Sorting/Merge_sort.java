package Sorting;

public class Merge_sort {

	public static void main(String[] args) {
		
		int[] arr = {30,43,12,54,76,41,47,12,1,66,34,23};
		
		Merge_sort m1 = new Merge_sort();
		m1.Msort(arr);
		m1.printArray(arr);

	}

	private void Msort(int[] arr) {
		int size = arr.length;
		if(size > 1) {
		
		int mid1 = 0;
		int mid2 = 0;
		
		int[] left_arr;
		int[] right_arr;
		
		
		if(size % 2 == 0) {
			mid1 = size/2;
			mid2 = size/2;
			left_arr = new int[mid1];
			right_arr = new int[mid2];
		
		}
		else {
			mid1 = size/2;
			mid2 = mid1+1;
			left_arr = new int[mid1];
			right_arr = new int[mid2];
		}
		
	
		for(int i = 0; i < mid1; i++) {
			left_arr[i] = arr[i];
		}
	
		for(int i = 0; i < mid2; i++) {
			right_arr[i] = arr[mid1];
			mid1++;
		}
		
		Msort(left_arr);
		Msort(right_arr);
		Merge(left_arr,right_arr,arr);
		
		}
	
	}

	private void Merge(int[] left_arr, int[] right_arr, int[] arr) {
		int nL = left_arr.length;
		int nR = right_arr.length;
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < nL && j < nR) {
			if(left_arr[i] <= right_arr[j]) {
				arr[k] = left_arr[i];
				i++;
			}
			else {
				arr[k] = right_arr[j];
				j++;
			}
			k++;
		}
		while(i < nL) {
			arr[k] = left_arr[i];
			i++;
			k++;
		}
		while(j < nR) {
			arr[k] = right_arr[j];
			j++;
			k++;
		}
	}
	
	private void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
