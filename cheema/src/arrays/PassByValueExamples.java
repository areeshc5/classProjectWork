package arrays;

import java.util.Arrays;

public class PassByValueExamples {

	public static void main(String[] args) {
		String s = "hello";
		Person p = new Person("Random", "Dude", Borough.NY_BOROUGHS[0]);
		int x =5;
		int[] arr = {1,2,3};
		test3(arr);
		//changeEVERYTHING(s,x,arr);
		System.out.println("p is now "+p+ " x is "+x+" and arr is "+Arrays.toString(arr));
	}
/** it is not posible to change an original reference via a local variable
 * as shown below
 * @param p
 * @param x
 * @param arr
 */
	private static void test1(Person p, int x, int[] arr) {
		String name = p.getFirstName();
		name = "Original";
	}
/**
 * you can change an object's references via its Setters
 * (methods that set fields)
 * @param s
 * @param x
 * @param arr
 */
	private static void test2(Person p, int x, int[] arr) {
		String name = "original";
		p.setFirstName(name);
	}
	//how to change arr via local variables
	//through its references(indices)
	//because primitives don't reference other data
	//(that's why they're called primitive)
	//it is not possible to change them via a local variables
	//like we did with objects and arrays
	private static void test3(int[] arr) {
		arr[0]=999;
		arr[1]= 998;
	}
	
	private static void changeEVERYTHING(String s, int x, int[] arr) {
		s = "bye";
		x = -5;
		arr = new int[2];
		arr[0]= -1;
		arr[1]= -2;
		
	}

}
