package ADA;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Exp4{
	
	private static double getMaxValue(int[] wt, int[] val,int capacity)
	{
		ItemValue[] iVal = new ItemValue[wt.length];

		for (int i = 0; i < wt.length; i++) {
			iVal[i] = new ItemValue(wt[i], val[i], i);
		}

		// sorting items by value;
		Arrays.sort(iVal, new Comparator<ItemValue>() {
			@Override
			public int compare(ItemValue o1, ItemValue o2)
			{
				return o2.cost.compareTo(o1.cost);
			}
		});

		double totalValue = 0d;

		for (ItemValue i : iVal) {

			int curWt = (int)i.wt;
			int curVal = (int)i.val;

			if (capacity - curWt >= 0) {
				// this weight can be picked while
				capacity = capacity - curWt;
				totalValue += curVal;
			}
			else {
			   // item cannot be picked whole
				double fraction = ((double)capacity / (double)curWt);
				totalValue += (curVal * fraction);
				capacity = (int)(capacity - (curWt * fraction));
				break;
			}
		}

		return totalValue;
	}
	
	// item value class
    static class ItemValue {
        Double cost;
        double wt, val, ind;
 
        // item value function
        public ItemValue(int wt, int val, int ind)
        {
            this.wt = wt;
            this.val = val;
            this.ind = ind;
            cost = ((double)val / (double)wt);
        }
    }

	
    
    
	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		int n;
		int capacity;
		int weight[] = new int[5];
		int value[] = new int[5];
		double wv[] = new double[5];
		
		Random rd = new Random();
		
		System.out.println("Enter the number of items : ");
		n = sc.nextInt();
		
		System.out.println("Enter the capacity of items : ");
		capacity = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			int rd1 = (int) rd.nextInt()/10000;
			int rd2 = (int) rd.nextInt()/10000;
			if(rd1 > 0 && rd1 <= 100 && rd2 > 10 && rd2 < 1000) {
				weight[i] = rd1;
				value[i] = rd2;
				wv[i] = (rd1/rd2);
			}
			else {
				i--;
			}
		}
		
		double maxValue = getMaxValue(weight,value,capacity);
		
		for(int i = 0; i < n ; i++) {
			System.out.println("Weight "+(i+1)+" : "+weight[i]+" | Value = "+value[i]+" |  wi/vi = "+wv[i]);
		}
		
		System.out.println();
		System.out.println("Maximum value that can be obtain is : "+maxValue);
		
		
        			
	}

}
