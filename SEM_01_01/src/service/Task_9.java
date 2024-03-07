package service;

public class Task_9 {
	final String inputEquation = "1 - 3 * 18 / 4 + 2";
	public void execute() {
		executeStringEquation(inputEquation);
	}
	double executeStringEquation(String inputEquation) {
		String[] equ = inputEquation.split(" ");
		String[] exp = new String[equ.length];
		for (int i = 0; i < equ.length; i++) {
			if (equ[i].equals("*")) {
				System.out.println("SOLVING");
				exp[i-1] = "" + Integer.valueOf(equ[i-1])*Integer.valueOf(equ[i+1]); 
				i++;
			}else{
				exp[i] = equ[i];
			} 
		}
		for (int i = 0; i < exp.length; i ++) {
			System.out.println(exp[i]);
		}
		
		return 0;
	}
}
