package model;

public class Student {
	private long st_ID 		= 0;
	private String name 	= "";
	private String surname 	= "";
	
	private static int auto_ST_ID = 0;
	
	public Student(long st_ID, String name, String surname) {
		if(st_ID == -1) {
			this.st_ID = auto_ST_ID;
			auto_ST_ID++;
		}else {
			this.st_ID = st_ID;
		}
		this.name = name;
		this.surname = surname;
	}
	public Student() {
		this.st_ID = auto_ST_ID;
		auto_ST_ID++;
		this.name = 	"NULL";
		this.surname = 	"NULL";
	}
	
	//GET
	public long getID() {
		return st_ID;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	//SET
	public void setName(String name) {
		if(name != null && name.matches("[A-Z]{1}[a-z]+(( [A-Z]{1}[a-z]+)?)+")){
			this.name = name;
		}else {
			this.name = "NULL";
		}
	}
	public void setSurname(String surname) {
		if(surname != null && surname.matches("[A-Z]{1}[a-z]+")){
			this.surname = surname;
		}else {
			this.surname = "NULL";
		}
	}
	
	@Override
	public String toString() {
		return "ID:" + st_ID + "\tNAME:" + name + " SURNAME:" + surname;
	}
}
