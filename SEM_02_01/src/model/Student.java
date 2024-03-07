package model;

public class Student extends Person{
	private long st_ID 		= 0;
	
	private static int auto_ST_ID = 0;
	
	public Student(long st_ID, String name, String surname, String personID) {
		super(name,surname,personID);
		if(st_ID == -1) {
			this.st_ID = auto_ST_ID;
			auto_ST_ID++;
		}else {
			this.st_ID = st_ID;
		}
	}
	public Student() {
		super();
		this.st_ID = auto_ST_ID;
		auto_ST_ID++;
	}
	
	//GET
	public long getID() {
		return st_ID;
	}
	
	//SET
	
	@Override
	public String toString() {
		return "ID:" + st_ID + "\tNAME:" + super.getName() +  "\tSURNAME:" + super.getSurname();
	}
}
