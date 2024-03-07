package service;

public class Task_5 {
	public void execute() {
		double[][] data = generateArray(5, 0, 5);
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				System.out.print(data[i][j]+ " ");
				
			}
			System.out.println("");
		}
		
		System.out.println(getProduct(data, 0,0));
		
	}
	double[][] generateArray(int N, double lower, double upper) {
		if (lower > upper) return new double [1][1];
		double[][] array = new double [N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				array[i][j] = ((Math.random() * (upper - lower)) + lower);
			}
		}
		return array;
	}
	double getProduct(double[][] matrix, int i, int j) {
		double product = 0;
		for (int I = 0; I < matrix.length; I++) {
			product = product + matrix[I][i] * matrix[j][I];
		}
		return product;
		
	}
}
