package Stack;

public abstract class Animal {
	

	private String name;
	private int id;
	
	public Animal(String name){
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public int getId() {
		return this.id;
	}
	
}



