package javaTheHardWay;

public class Predator extends ReproductionAnimal{

	public Predator(Habitat matingArea) {
		super(matingArea);
		setmaxLitter(3);
		
	}
	
	public Predator(Habitat matingArea, String description, Trait trait1, Trait trait2) {
		super(matingArea, description, trait1, trait2);
		setmaxLitter(3);
	}
	
	public static final String[] PREDATORS = {"wolf", "bear", "lion", "bobcat"};
	public String getName() {
		return PREDATORS[(int)(Math.random()* PREDATORS.length)];
	}
	
	public static void main(String[] args) {
		Wilderness wild = new Wilderness("A wooded Area", 10);
		Predator p = new Predator(wild);
		wild.addAnimal(p);
		wild.stimulate(2);
	}
	
	public ReproductionAnimal getOffspring(ReproductionAnimal mate) {
		return new Predator(habitat, getDescription(), Trait.getDominantTrait(getTrait1(), mate.getTrait1()),
				Trait.getDominantTrait(getTrait2(), mate.getTrait2()));
	}
	
	public boolean canEat() {
		int attempts = 0;
		while(attempts < 3) {
			int tIndex = (int)(Math.random()*habitat.getAnimals().length);
			Animal target = habitat.getAnimals()[tIndex];
			if(target instanceof Prey) {
				habitat.removeAnimal(tIndex);
				return true;
			}
			attempts++;
		}
		return false;
	}

}
