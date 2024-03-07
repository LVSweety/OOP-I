package service;

import java.util.Random;

public class Task_6 {
	public void execute() {
		double[] data = coinFlip(1000);
		for (int i = 0; i < data.length; i ++) {
			System.out.print(data[i] + " ");
		}
		System.out.println("");
		
		int[] flips = rollDice(1000);
		for (int i = 0; i < flips.length; i ++) {
			System.out.print(flips[i] + " ");
		}
		System.out.println("");
		
		System.out.println(roll2Dices());
		
	}
	double[] coinFlip(int N) {
		double[] array = new double [3];
		for (int i = 0; i < N; i++) {
			Random rnd = new Random();
			if (rnd.nextInt(2) == 1) {
				array[1]++;
			}else {
				array[0]++;
			}
		}
		array[2] = array[0]/array[1]; 
		return array;
	}
	int[] rollDice(int N) {
		int[] array = new int [6];
		for (int i = 0; i < N; i++) {
			Random rnd = new Random();
			array[rnd.nextInt(6)]++;
		} 
		return array;
	}
	int roll2Dices() {
		int tries = 0;
		Random rnd = new Random();
		while (true) {
			tries++;
			if (rnd.nextInt(6) == 5 && rnd.nextInt(6) == 5) {
				return tries;
			}
		} 
		
	}

}
