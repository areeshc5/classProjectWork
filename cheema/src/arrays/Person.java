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
	private Hobby hobby;
	private Person[] friends;
	
	public Person(String first, String last, Borough home) {
		this.firstName = first;
		this.lastName= last;
		this.home = home;
		friends = new Person[3];
		hobby = Hobby.randomHobby();
	}
	
	public void stateYourFriends() {
		String statement = "My friends are ";
		for(int i =0; i < friends.length-1; i++) {
			statement += friends[i].firstName + ",";
		}
		statement += "and " + friends[friends.length -1];
		System.out.println(statement);
	}
	
	public void mingle(Person[] peers) {
		for(Person p: peers) {
			//cannot friend yourself
			if(p != this) {
				setInFirstPlace(p);
			}
		}
	}
	
	public void setInFirstPlace(Person f) {
		//go backwards through an array
		for(int i = friends.length -1; i > 0; i--) {
			//move friend from in front, back
			friends[i]=friends[i-1]; //CHECK: does not go OFB
		}
		friends[0] = f;
	}
	
	public String toString() {
		return "My name is "+firstName+" "+lastName+
				" and I am from "+home+".";
	}
		
}
