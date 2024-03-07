package service;

public class Task_1 {
	
	private String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
	private int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317};

	
	public void execute() {
		if(names.length == times.length) return;
		for(int i = 0; i < names.length - 1; i++) {
			System.out.println("[" + names[i] + ", <" + times[i] + ">]:");
		}
	}
}
