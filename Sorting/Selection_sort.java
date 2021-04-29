package Sorting;

public class Selection_sort {

	public static void main(String[] args) {
		
		int[] arr = {6,5,4,3,2,1};
		
		Selection_sort s1 = new Selection_sort();
		s1.Ssort(arr,arr.length);
		
		
	}

	private void Ssort(int[] arr, int length) {
		
		for(int i = 0; i < length-1 ;i++) {
			int min = arr[i];
			for(int j = i+1 ; j < length ; j++) {
				if(arr[j] <= arr[i]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		
		for(int i = 0 ; i < length ; i++) {
			System.out.println(arr[i]);
		}
		
	}

}
