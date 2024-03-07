package service;

public class Task_4 {
	public void execute() {
		double[] data = generateArray(100, 0, 5);
		
		for (int i = 0; i < data.length - 1; i ++) {
			System.out.print(data[i] + " ");
		}
		System.out.println(" ");
		
		System.out.println(getMean(data));
		
		data = arraySort(data);
		
		for (int i = 0; i < data.length - 1; i ++) {
			System.out.print(data[i] + " ");
		}
		System.out.println(" ");
		
		System.out.println(getMin(data));
		
		System.out.println(getMax(data));
	}
	double[] generateArray(int N, double lower, double upper) {
		if (lower > upper) return new double [1];
		double[] array = new double [N];
		for (int i = 0; i < N; i++) {
			array[i] = ((Math.random() * (upper - lower)) + lower);
		}
		return array;
	}
	double getMean(double[] array) {
		double sum = 0.0;
		for (int i = 0; i < array.length - 1; i ++) {
			sum = sum + (array[i]/array.length);
		}
		return sum;
		
	}
	double getMin(double[] array) {
		double[] data = arraySort(array);
		return data[0];
		
	}
	double getMax(double[] array) {
		double[] data = arraySort(array);
		return data[data.length-1];
	}
	double[] arraySort(double[] array) {
		int i, j; 
		double temp;
        boolean swapped;
        for (i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                     
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
        return array;
	}

}
