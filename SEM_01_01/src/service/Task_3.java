package service;

public class Task_3 {
	
	public void execute() {
		System.out.println(factorialRecursive(10));
		System.out.println(factorialForLoop(10));
	}
	private int factorialForLoop(int N) {
		if (N < 0) return 0;
		int factorial = 1;
		for (int i = 1; i < N; i ++) {
			factorial = factorial * (i+1);
		}
		return factorial;
		
	}
	private int factorialRecursive(int N) {
		if (N < 0) return 0;
		if (N == 0) return 1;
		return N * factorialRecursive(N - 1);
	}
}
