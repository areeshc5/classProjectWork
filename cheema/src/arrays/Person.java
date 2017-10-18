package arrays;

public class Person {
	
	public static final String[] FIRST_START = {"Chr", "Ar", "Vic","Th","Jes","Da","Pen"};
	public static final String[] FIRST_MIDDLE = {"is", "ebos", "ke","ala","ola","e","dar"};
	public static final String[] FIRST_END = {"na", "rol", "a","e","u","i","u"};
	
	public static final String[] LAST_START = {"Sm", "Ar", "Vic","Th","Jes","L","Bor"};
	public static final String[] LAST_MIDDLE = {"it", "be", "oom","ll","tr","cu","stien"};
	public static final String[] LAST_END = {"h", "son", "a","e","u","la","en"};
	
	private String firstName;
	private String lastName;
	private Borough home;
	
	public Person(String first, String last, Borough home) {
		this.firstName = first;
		this.lastName= last;
		this.home = home;
	}
	
	public String toString() {
		return "My name is "+firstName+" "+lastName+
				" and I am from "+home+".";
	}
		
}
