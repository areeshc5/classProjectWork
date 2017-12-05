package algorithims;

public class FibonacciNumbers {

	public static void main(String[] args) {
		

	}
	
	public int fib(int num){
		//1,1,2,3,5,8,13,21,34....
		
		if(num <= 1) {
			return 1;
		}
		else {
			return fib(num-1) + fib(num-2);
		}
	}
	
	

}
