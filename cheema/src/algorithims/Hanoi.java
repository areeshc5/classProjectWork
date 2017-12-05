package algorithims;

public class Hanoi {

	public static void main(String[] args) {
		hanoi(5 , "A", "B", "C");
	}


	
	public static void hanoi(int n, String start, String help, String end) {
		if(n==1) {
			System.out.println(start +" to "+end);
		}
		
		else {
			hanoi(n-1, start, end, help);
			System.out.println();
			hanoi(n-1, help, start, end);
		}
	}
			
	
}
