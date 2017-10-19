package arrays;
//an array is a class you don't write, it is generated during runtime
public class ObjectMain {

	public ObjectMain() {
		Person[] people = new Person[120];
		populate(people);
		//people[0] = new Thing("toaster oven");
		Person[] group = selectGroup(people, 120);
		analyzeCommanalities(people, group);
		//for(Object p: group) {
		//	System.out.println(p);
		//}
		for(Person p: people) {
			p.mingle(people);
			System.out.println(p);
			p.stateYourFriends();
		}
	}
	//BIG IDEAS AP STYLE 
	private void analyzeCommanalities(Person[] people, Person[] group) {
		double averageCom = 0;
		double trials = 500;
		//code goes here
		double sumCounts = 0;
		for(int i =0; i < trials; i++) {
			group = selectGroup(people, people.length);
			sumCounts += countCommonalities(people, group);
		}
		
		averageCom = sumCounts/500;
		
		System.out.println("After "+trials+ " trials, shuffling "+people.length+" people, on average, "
				+averageCom+" people end up in the same position where they started.");
		
	}

	private void populate(Person[] people) {
		for (int i =0; i <people.length; i++) {
			String firstName = randomNameFrom(Person.FIRST_START,
					Person.FIRST_MIDDLE,Person.FIRST_END);
			String lastName = randomNameFrom(Person.LAST_START,
					Person.LAST_MIDDLE,Person.LAST_END);
			Borough home = randomBorough();
			//BIG IDEA
			//in an object array, you can have multiple data types
			// this is unlike a primitive array(int, boolean, etc)
			if(Math.random() < .6) {
			//60% of the time
			int money = (int)(Math.random()*20+1 )*10000;
			people[i]= new Athlete(firstName, lastName, home, money);
			}
			else {
				//the other 40% of the time
			people[i]= new Person(firstName, lastName, home);
		}
		}
	}

	private Borough randomBorough() {
		return Borough.NY_BOROUGHS[(int)(Math.random()*Borough.NY_BOROUGHS.length)];
	}

	private String randomNameFrom(String[] a, String[] b, String[] c) {
		return get(a)+get(b)+get(c);
		
	}

	private String get(String[] a) {
		return a[(int)(Math.random()*a.length)];
	}

	public static void main(String[] args) {
		ObjectMain obj = new ObjectMain();

	}
	//both arr are the same length
	//returns the number of items that are the same in both arr and at the same index
	private int countCommonalities(Object[] arr1, Object[] arr2) {
		int count = 0;
		for(int i = 0; i< arr1.length; i++) {
				if(arr1[i]== arr2[i]) {
					count++;
				}
			}
		return count;
	}
	public Person[] selectGroup(Person[] population, int length) {
		Person[]  group = new Person[length];
		for(int i =0; i < length; i++) {
			Person toAdd = randomPerson(population);
			while(alreadyContains(group, toAdd)) {
				toAdd = randomPerson(population);
			}
			group[i]= toAdd;
		}
		return group;
	}
	//returns a randomly selected Person from pop
		private Person randomPerson(Person[] population) {
			int index = (int)(Math.random()* population.length);
			return population[index];
			
		}
	//returns true if pop already has p in it
	private boolean alreadyContains(Person[] population, Person p) {
		for(int i = 0; i < population.length; i ++) {
			if(population[i] == p) {
				return true;
			}
		}
		return false;
	}
	
}
