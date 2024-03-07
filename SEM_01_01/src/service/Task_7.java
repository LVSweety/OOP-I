package service;

public class Task_7 {
	private final byte[] list = {72, 101, 108, 108, 111, 33, 32, 77, 121, 32, 115, 107, 105, 108, 108, 115, 32, 97, 114, 101, 32, 103, 114, 101, 97, 116, 32, 97, 108, 114, 101, 97, 100, 121, 33};
	public void execute() {
		System.out.println(getTextFromBytes(list));
	}
	String getTextFromBytes(byte[] array) {
		String proc = "";
		for (int i = 0; i < array.length; i++) {
			 proc = proc + (char)(array[i]);
		}
		return proc;
	}

}
