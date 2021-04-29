package Sorting;

public class Quick_sort {

	public static void main(String args[]) {
		
		int[] arr = {89,43,32,54,12,65,87,43,76,54};
		
		Quick_sort q1 = new Quick_sort();
		q1.Qsort(arr,0,9);
		q1.printArray(arr);
	}

	private void Qsort(int[] arr, int beg, int end) {
		
		if(beg < end) {
		int pindex = Partition(arr,beg,end);
		Qsort(arr,beg,pindex-1);
		Qsort(arr,pindex+1,end);
		}
		
	}

	private int Partition(int[] arr, int beg, int end) {
		int pivot  = arr[end];
		int pivot_index = beg-1;
		
		for(int i = beg ; i < end; i++) {
			if(pivot >= arr[i]) {
				pivot_index++;
				int temp = arr[pivot_index];
				arr[pivot_index] = arr[i];
				arr[i] = temp;	
			}
		}
		
		int temp = arr[end];
		arr[end] = arr[pivot_index+1];
		arr[pivot_index+1] = temp;
		return (pivot_index+1);
	}
	
	public void printArray(int[] arr) {
		for(int i =0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
