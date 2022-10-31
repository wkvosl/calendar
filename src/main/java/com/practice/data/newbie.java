package com.practice.data;

public class newbie {

	public static void main(String[] args) {

		Rpg<String, Integer> R1 = new Rpg<String, Integer>();

		R1.character("1", 10);
//		R1.character("1", "10");  
//		R1.character(1, "10");  
		System.out.println("R1: "+R1);
		
		
		Rpg<String, Integer> R2 = new Rpg<>();

		R2.character("1",100);
//		R2.character("2","2");
//		R2.character(2,2);
		System.out.println("R2: "+R2);

		
		Rpg<String, Integer> R3 = new Rpg();
		
//		R3.character("3", 3);//		
//		R3.character("3", "3");
//		R3.character(3, 3);
		System.out.println("R3: "+R3);
		
		
		Rpg R4 = new Rpg();
		
		R4.character(4, 4);
		R4.character("4", 4);	
		R4.character("4", "4");
		System.out.println("R4 "+R4);
		
	}


}
class Rpg<T, S> {

	public T name;
	public S level;

	void character(T name, S level) {
		this.name = name;
		this.level = level;
	}

	@Override
	public String toString() {
		return "Rpg [name=" + name + ", level=" + level + "]";
	}

	public T getName() {
		return name;
	}

	public void setName(T name) {
		this.name = name;
	}

	public S getLevel() {
		return level;
	}

	public void setLevel(S level) {
		this.level = level;
	}

}