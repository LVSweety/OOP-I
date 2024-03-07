package service;

public class Task_2 {
	private final double gravity = -9.81; // Earth's gravity in m/s^2
	private final double initialVelocity = 0.0;
	private final double fallingTime = 10.0;
	private final double initialPosition = 0.0;

	public void execute() {
		System.out.println(positionCalc(gravity, initialVelocity, initialPosition, fallingTime));
	}
	
	private double positionCalc(double g, double v0, double x0, double t) {
		return x0+v0*t+(0.5*g*t*t);
		
	}
}
