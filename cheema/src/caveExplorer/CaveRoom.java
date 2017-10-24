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
	
	public void enter() {
		contents = "X";
	}
	public void leave() {
		contents = defaultContents;
	}
	/**
	 * this is how we join rooms together
	 * it gives this room access to anotherRoom and vice versa
	 * it also puts the door between both rooms
	 * @param direction
	 * @param anotherRoom
	 * @param door
	 */
	public void setConnection(int direction, CaveRoom anotherRoom,Door door) {
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this,door);
	}
	public void addRoom(int dir, CaveRoom caveRoom, Door door) {
		borderingRooms[dir] = caveRoom;
		doors[dir] = door;
		setDirections();//updates directions
		
	}
	
	public void interpretingInput(String input) {
		while(!isValid(input)) {
			System.out.println("You can only enter 'w', 'a', 's', or 'd'.");
			input = CaveExplorer.in.nextLine();
		}
		int direction = "wdsa".indexOf(input);
		
		goToRoom(direction);
	}
	
	/**
	 * returns true if input equals wasd
	 * @param input
	 * @return
	 */
	private boolean isValid(String input) {
		return "wasd".indexOf(input) > -1 && input.length() ==1;
		
	}
	/**
	 * this is where you edit your caves
	 */
	public static void setUpCaves() {
		
	}
	public void goToRoom(int direction) {
		//make sure there is a room to go to
		if(borderingRooms[direction] != null && doors[direction] != null 
				&& doors[direction].isOpen()) {
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
		}
		else {
			//print red text
			System.err.println("You can't do that");
		}
	}
	/** returns the OPPOSITE direction
	 * oD(0) returns 2
	 * oD(1) returns 3
	 * @param dir
	 * @return
	 */
	public static int oppositeDirection(int dir) {
		//int[]  dire = {2,3,0,1};
		//return dire[dir];
		return (dir+2)%4;
		
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
