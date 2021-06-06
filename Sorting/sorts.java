package Testing;

import java.util.Arrays;
import java.util.Scanner;

public class sorts {

	private static int[] Swap(int left, int right, int[] array) {

		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;

		return array;
	}

	private static int[] InsertionSort(int[] array) {

		for (int i = 1; i < array.length; i++) {
			int value = array[i];
			int hole = i;
			while (hole > 0 && array[hole - 1] > value) {
				array[hole] = array[hole - 1];
				hole--;
			}
			array[hole] = value;
		}
		return array;
	}

	private static int[] BubbleSort(int[] array) {

		for(int i = 0; i < array.length; i++ ) {
			for(int j = 0; j < array.length-1; j++) {
				if(array[j] > array[j+1]) {
					array = Swap(j,j+1,array);
				}
			}
		}

		return array;
	}

	private static int[] SelectionSort(int[] array) {

		for(int i = 0; i < array.length-1 ; i++) {
			for(int j = i+1; j < array.length; j++) {
				int min = i;
				if(array[j] < array[min]) {
					min = j;
					Swap(i,min,array);
				}

			}
		}

		return array;
	}

	private static int[] MergeSort(int[] array) {

		int size = array.length;

		if(size > 1) {

			int[] leftArr;
			int[] rightArr;

			if(size % 2 == 0) {
				int mid1 = size/2;
				int mid2 = mid1;
				leftArr = new int[mid1];
				rightArr = new int[mid2];
			}
			else {
				int mid1 = size/2;
				int mid2 = mid1+1;
				leftArr = new int[mid1];
				rightArr = new int[mid2];
			}

			for(int i = 0; i < leftArr.length ; i++) {
				leftArr[i] = array[i];
			}
			int j = leftArr.length;
			for(int i = 0; i < rightArr.length; i++) {
				rightArr[i] = array[j];
				j++;
			}

			MergeSort(leftArr);
			MergeSort(rightArr);
			array = Merge(leftArr,rightArr,array);

		}
		else {

		}
		return array;
	}

	private static int[] Merge(int[] leftArr, int[] rightArr, int[] array) {

		int sizeLeftArr = leftArr.length;
		int sizeRightArr = rightArr.length;
		int i = 0;
		int j = 0;
		int k = 0;

		while(i < sizeLeftArr && j < sizeRightArr) {
			if(leftArr[i] < rightArr[j]) {
				array[k] = leftArr[i];
				i++;
			}
			else {
				array[k] = rightArr[j];
				j++;
			}
			k++;
		}
		while(i < sizeLeftArr) {
			array[k] = leftArr[i];
			i++;
			k++;
		}
		while(j < sizeRightArr) {
			array[k] = rightArr[j];
			j++;
			k++;
		}

		return array;
	}

	private static void Quicksort(int[] arr, int beg, int end) {

		if(beg < end) {
			int pindex = Partition(arr,beg,end);
			Quicksort(arr,beg,pindex-1);
			Quicksort(arr,pindex+1,end);
		}

	}

	private static int Partition(int[] arr, int beg, int end) {
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

	private static void printArray(int[] array) {
		for (int a : array) {
			System.out.print(" " + a);
		}
		System.out.println();
		System.out.println();
	}

	private static int[] constructArray(int[] array) {

		int count = 7;
		for(int i = 0; i < array.length; i++) {
			array[i] = count;
			count--;
		}

		return array;
	}
	
	private static int BinarySearch(int[] array,int searchElement,int beg,int end) {
		
		if(end >= 1) {
			
			int mid = beg+ (end-beg) / 2;
			
			if(array[mid] == searchElement) {
				return mid;
			}
			else if(searchElement > array[mid]) {
				return BinarySearch(array,searchElement,mid+1,end);
			}
			else {
				return BinarySearch(array,searchElement,beg,mid-1);
			}
		}
		return -1;	
			
	}
	
	private static void HeapSort(int arr[])
    {
        int n = arr.length;
        System.out.println(n / 2 - 1);
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
 
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
 
    private static void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

	public static void main(String[] args) {



		int[] array = { 6, 5, 4, 3, 2, 1, 7 };

		System.out.println("--> Insertion sort program : ");
		array = InsertionSort(array);
		printArray(array);


		System.out.println("--> Bubble sort program : ");
		array = constructArray(array);
		array = BubbleSort(array);
		printArray(array);


		System.out.println("--> Selection sort program : ");
		array = constructArray(array);
		array = SelectionSort(array);
		printArray(array);


		System.out.println("--> Merge sort program : ");
		array = constructArray(array);
		array = MergeSort(array);
		printArray(array);


		System.out.println("--> Quick sort program : ");
		array = constructArray(array);
		Quicksort(array,0,array.length-1);
		printArray(array);
		
		System.out.println("--> Binary search program : ");
		array = constructArray(array);
		Arrays.sort(array);
		printArray(array);
		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter element to be searched : ");
//		int searchElement = sc.nextInt();
//		System.out.println("Element found at pos : "+(BinarySearch(array,searchElement,0,array.length-1)+1));
		
		
		System.out.println("--> Heap sort program : ");
		array = constructArray(array);
		HeapSort(array);
		printArray(array);
	}
}
