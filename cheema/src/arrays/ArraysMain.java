package arrays;

import java.util.Arrays;

public class ArraysMain {

	private String[] suits;
	private String[] values;
	
	public ArraysMain() {
			//warmUpMethods();
			tuesdayMethods();
			//populate1toN(testArray);
			//shuffle(testArray);
			//populate(testArray);
			//countOccurances(testArray,2,12);
			//System.out.println(Arrays.toString(testArray));
	}
	private void tuesdayMethods() {
		int[] orderTest= {1,2,3,4,5,1,6,7,8,9,10,11};
		//frontToBack(orderTest);
		//cycleThrough(orderTest,5);
		//System.out.println(Arrays.toString(orderTest));
		System.out.println(longestConsecutiveSequence(orderTest) + " is the l.c.s");
	}
	private void cycleThrough(int[] arr, int n) {
		for(int i=0; i <n; i++) {
			frontToBack(arr);
		}
		
	}
	/**
	 * return the length of the longest cons. sequence in the array
	 * lCS(1,2,3,2,3,4,5,2,3,4)->4
	 * @param arr
	 * @return
	 */
	public int longestConsecutiveSequence(int[] arr) {
		int maxLength = 1;
		int currentCount = 1;
		
		for(int i =0; i<arr.length; i++) {
			while(i+currentCount < arr.length && isConsecutive(arr, i , i+currentCount)) {
				currentCount++;
			}
			if(currentCount > maxLength) {
				maxLength = currentCount;
			}
			i = i+currentCount-1; //saves time
			currentCount=1;
		}
		return maxLength;
	}
	private boolean isConsecutive(int[] arr, int start, int end) {
		for(int i = start; i < end; i++) {
			if(arr[i]+1 != arr[i+1]) {
				return false;
			}
		}
		return true;
	}
	/**
	 * removes the element at index 0, pushes all others forward
	 * 1goes to 0, 2 goes to 1
	 * puts the element that was at 0 at the end
	 * @param orderTest
	 * @return
	 */
	private void frontToBack(int[] arr) {
		int placeholder= arr[0];
		for(int i =0; i< arr.length-1; i++) {
			
			arr[i]=arr[i+1];
		}
		arr[arr.length-1]=placeholder;
	}
	private void warmUpMethods() {
		int[] orderTest= {1,2,3,4,5,6,7,8,9,10};
		reverseOrder(orderTest);
		System.out.println(Arrays.toString(orderTest));
		System.out.println(Arrays.toString(subArray(orderTest,3,4)));
	}
	public void reverseOrder(int[] arr) {
		
		for(int i =0; i < arr.length/2; i++) {
			swap(arr, i,arr.length-1-i );
		}
	}
	public int[] subArray(int[] arr, int psn, int length) {
		int[] resultArr = new int[length];
		for(int i = 0; i <length; i++) {
			resultArr[i] = arr[i+psn];
		}
		return resultArr;
	}
	
	public void cardMethods() {
		suits = new String[4];
		suits[0]= "clubs";
		suits[1]= "Hearts";
		suits[2]= "Diamonds";
		suits[3]= "Spades";
		values = new String[13];
		for(int i =0; i < values.length; i++) {
			values[i] = "" +(i+1);
		}
		values[0]="Ace";
		values[12]="King";
		values[11]="Queen";
		values[10]="Jack";
		printDeck();
	}
	private String[] printDeck() {
		String[] deck = new String[52];
		int index= 0;
		for(String suit: suits) {
			for(String value: values) {
				deck[index] = value + " of " + suit;
				index++;
			}
		}
		return deck;
		
	}
	private void shuffle(int[] arr) {
		for(int i =0; i < arr.length; i ++) {
			swap(arr,i, (int)(Math.random()*arr.length));
		}
	}
	/**
	 * swap elements at i and j
	 * @param arr
	 * @param i
	 * @param j
	 */
	private void swap(int[] arr, int i, int j) {
		int k = arr[i];
		
		arr[i] = arr[j];
		arr[j] = k;	
	}
	/**
	 * populate arr with number from 1 to arr.length, in order
	 * @param arr
	 */
	private void populate1toN(int[] arr) {
		for(int i =0; i < arr.length; i++) {
			arr[i]=(i+1);
			
		}
		
	}
	private void countOccurances(int[] arr, int start, int end) {
		//why create an array with this length?
				int[] counter = new int[end-start+1];
				for(int value: arr) {
					//why value - start
					counter[value - start]++;
				}
				for(int i =0; i <counter.length; i++) {
					System.out.println("The value "+(i+start)+ 
					" was rolled " +counter[i]+ " times.");
				}
	}
	private void populate(int[] arr) {
		//this method populates arr with results from rolling 2 dice
		// correct way
		for(int i = 0; i < arr.length; i++) {
			arr[i]=diceRoll(2);
		}
		/* incorrect // does nothing
		 * for(int value: arr){
		 * value = diceRoll(2);
		 * }
		 */
		
	}
	public void arrayNotes() {
		//two ways to construct an array;
				int[] firstWay = {0,1,2,3,4,5};
				//this way will only work with the declaration
				/* will not work:
				 * firstWay = {6,7,8,9,10};
				 */
				
				String[] secondWay = new String[5];
				//you can go on like so, creating values at each index
				//secondWay[0]=1;
				//secondWay[1]=10;
				//Primitive arrays auto-populate with 0
				//Object arrays are not populated (null)
				
				//TWO WAYS TO ITERATE THROUGH AN ARRAY:
				for(int i = 0; i < secondWay.length; i++) {
					System.out.println("The #" +i+ " element is " +secondWay[i]);
				}
				//"for each int in secondWay"
				//does not provide index
				for(String value: secondWay) {
					System.out.println("Element is " +value);
				}

	}
	public static void main(String[] args) {
		
		ArraysMain sample = new ArraysMain();
		//1. Arrays are collections of primitives and Objects
		//SPECIAL NOTE: This is the ONLY collection of primitives
		//2. Size cannot be edited
		
		/*3. Elements of an array are REFERENCES to objects. In other words,
		changing an element of an array changes the reference, not the object.*/
	}
	
	/**
	 * returns the result after rolling n number of dice
	 * @param n
	 * @return
	 */
	public int diceRoll(int n) {
		int sum = 0;
		for(int i = 0; i < n; i++) {
			int dieRoll = (int) (Math.random()*6)+1;
			sum += dieRoll;
		}
		return sum;
	}
}
