package interfaces;

public class ZooAnimalRunner {
	
	public static void main(String[] args) {
		
		ZooAnimal[] zoo = new ZooAnimal[3];
		
		zoo[0] = new Snake();
		zoo[1] = new Tiger();
		zoo[2] = new Tiger();
		
		for (ZooAnimal z : zoo) {
			z.speak();
			z.habitat();
		}

		
	}
}
