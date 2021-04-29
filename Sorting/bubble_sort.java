package Sorting;

public class bubble_sort {

	
	public static void main(String[] args) {
		
		int[] arr = {6,5,4,3,2,1};
		
		bubble_sort b1 = new bubble_sort();
		b1.Bsort(arr,arr.length);

	}

	private void Bsort(int[] arr, int length) {
		
		for(int i = 1 ; i < length  ; i++) {
			for(int j = i+1; j < length-1; j++) {
				if(arr[i] <= arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		for(int i = 0; i < length ; i++) {
			System.out.println(arr[i]);
		}
		
	}

}
