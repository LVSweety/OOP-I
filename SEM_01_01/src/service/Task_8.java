package service;

public class Task_8 {
	public void execute() {
		int[] data = pascalsTriangle(0);
		for (int i = 0; i < data.length; i ++) {
			System.out.print(data[i] + " ");
		}
		System.out.println("");
		
	}
	int[] pascalsTriangle(int level) {
		int[] line = new int[level+1];
		for (int i = 0; i < level+1; i++) {
			line[i] = fact(level)/(fact(i)*fact(level-i));
		}
		return line;
	}
	
	private int fact(int N) {
		if (N < 0) return 0;
		int factorial = 1;
		for (int i = 1; i < N; i ++) {
			factorial = factorial * (i+1);
		}
		return factorial;
		
	}
}
