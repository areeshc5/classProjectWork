package arrays;

public class Hobby extends Thing {

	public Hobby(String description) {
		super(description);
	}

	public static Hobby randomHobby() {
		Hobby[] h = {new Hobby("reading"), new Hobby("dancing"), new Hobby("sleeping")};
		return h[(int)(Math.random()*h.length)];
		
	}
}
