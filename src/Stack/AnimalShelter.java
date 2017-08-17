package Stack;

import java.util.LinkedList;

public class AnimalShelter {

	private LinkedList<Dog> dogList= new LinkedList<Dog>();
	private LinkedList<Cat> catList= new LinkedList<Cat>();
	private int id=0;
	
	
	public void enqueue(Animal animal){
		
		animal.setId(id++);
		
		if(animal instanceof Dog){
			dogList.add((Dog)animal);
		}
		
		if(animal instanceof Cat){
			catList.add((Cat) animal);
		}
	}
	
	
	public Dog dequeueDog(){
		return dogList.pollFirst();		
	}
	
	public Cat dequeueCat(){
		return catList.pollFirst();
	}
	
	public Animal dequeueAny(){
		
		if(dogList.isEmpty() && catList.isEmpty())
			return null;
		
		if(catList.isEmpty())
			return dogList.poll();
	
		if(dogList.isEmpty())
			return catList.poll();
		

		if(dogList.peek().getId() < catList.peek().getId()){
			return dogList.poll();
		}
		
		return catList.poll();
		
	}
	
	
}

