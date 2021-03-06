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
	private String nickname;
	
	public Person(String first, String last, Borough home) {
		this.firstName = first;
		this.lastName= last;
		this.home = home;
		friends = new Person[3];
		hobby = Hobby.randomHobby();
		nickname = createNickname(firstName);
	}
	/**
	 * PASS BY VALUE
	 * the parammeters of a method contain only values not references
	 * therefore, when they are changed, the REFERENCE to the original
	 * object does not change
	 * 
	 * returns a string equal to name up to index of(but not including)
	 * the 2nd vowel
	 * @param name
	 * @return
	 */
	public static String createNickname(String name) {
		String nickname ="";
		int vowelCount = 0;
		for(int i =0; i <name.length(); i ++) {
			String letter = name.substring(i, i+1);
			if(isVowel(letter)) {
				vowelCount++; 
				if(vowelCount != 2) {
					nickname +=letter;
				}
				else {
					return nickname;
				}
			}
			else {
				//add the letter when not a vowel
				nickname += letter;
			}
		}
		return nickname;
	}
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
	public static boolean isVowel(String letter) {
		letter = letter.toLowerCase();
		return(letter.equals("a")||letter.equals("e")||letter.equals("i")||letter.equals("o")||letter.equals("u"));
		

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
		return "My name is "+firstName+" "+lastName+". Call me "+nickname+ ". "+
				" and I am from "+home+".";
	}
		
}
