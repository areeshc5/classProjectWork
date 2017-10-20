package arrays2D;

import arrays.Array2DSampler;

public class Main {
	
	public static void main(String[] args) {
		
		//int[] arr = {4,3,2,1,0};
		//changeNeighbors(arr, 2);
		Array2DSampler test = new Array2DSampler();
	}
	/**
	 * PRECONDITION: i >=0 and i <arr.length
	 * increases the element at i by 1
	 * decreases the elements at i + 1 and i -1, if they exist
	 * AVOIDS ArrayIndexOutOfBoundsException
	 * THIS IS SUCH A HEAVILY TESTED CONCEPT ON EVERY EXAM
	 * YOU SHOULD ALWAYS BE IN THE HABIT OF CHECKING FOR 
	 * ARRAYINDEXOUTOFBOUNDS EXCEPTION
	 * you'll ose major points
	 * 
	 */

	private static void changeNeighbors(int[] arr, int i) {
		arr[i] = arr[i]+1;
		if(i < arr.length) {
			arr[i] = arr[i] +1;
		}
		if(i > arr.length) {
			arr[i]=arr[i]-1;
		}
	}

}
