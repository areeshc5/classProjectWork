package caveExplorer;

public class CaveRoom {

	private String decription;
	private String directions;//tells you which doors can be used
	private String contents;//a symbol showing you what is in the room
	//(x when you are in the room)
	private String defaultContents;// what is in the room when you aren't
	
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	//constants
	public static final int NORTH =0;
	public static final int EAST =1;
	public static final int SOUTH =2;
	public static final int WEST =3;
	
	public CaveRoom(String description) {
		this.decription = description;
		setDefaultContents("");
		contents = defaultContents;
		//NOTE; arrays are instantiated with 'null' values
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}
	/**
	 * for every door in doors[] that is not null,
	 * this method appends a String to "directions" describing the door and where it is
	 * there is a (passage) to (the north)
	 * if there are no doors that are not null, this sets 
	 * directions to "There is no way out, you are trapped"
	 */
	public void setDirections() {
		directions = "";
		//hint: to check if a door is null, use:
		//doors[0] == null OR use doors[0] != null
		for(int i=0; i <doors.length; i++) {
		if(doors[i]==null) {
			directions = "There is no way out, you are trapped";
		}
		else {
			directions +="There is a "+doors[i].getDescription()+ " to the "+
					toDirection(i)+". "+doors[i].getDetails();
		}
		
		}
	}
	//converts an int to a direction
	public static String toDirection(int dir) {
		String direction[] = {"the North", "the East", "the West","the South"};
		//NOTE: when I say "no if-else" statements,
		//this is how you should be thinking
		return direction[dir];
	
	}
	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

}
