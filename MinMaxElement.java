package DivideandConquer;

import java.util.Scanner;

public class MinMaxElement {
	
	static class MinMax{
		int max;
		int min;
	}
	
	static MinMax getMinMax(int arr[], int low, int high) {
		MinMax obj = new MinMax();
		MinMax Larr = new MinMax();
		MinMax Rarr = new MinMax();
		//if there is only one element 
		if(low == high) {
			obj.max = arr[low];
			obj.min = arr[low];
			return obj;
		}
		
		//if there are two elements
		if(high == low+1) {
			if(arr[low] > arr[high]) {
				obj.max = arr[low];
				obj.min = arr[high];
			}
			else {
				obj.max = arr[high];
				obj.min = arr[low];
			}
			return obj;
		}
		
		//if there are more than two elements
		int mid = (low+high)/2;
		Larr = getMinMax(arr, low, mid);
		Rarr = getMinMax(arr, mid+1, high);
		//compare minimum of two parts
		if(Larr.min < Rarr.min) {
			obj.min = Larr.min; 
		}
		else {
			obj.min = Rarr.min;
		}
		
		//compare maximum of two parts
		if(Larr.max > Rarr.max) {
			obj.max = Larr.max;
		}
		else {
			obj.max = Rarr.max;
		}
		return obj;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		MinMax obj = getMinMax(array, 0, n-1);
		System.out.printf("Maximum Element %d", obj.max);
		System.out.printf("\nMinimum Element %d",obj.min);
		sc.close();
	}

}
