package model;

public class Student {
	private long st_ID 		= 0;
	private String name 	= "";
	private String surname 	= "";

	private String personID = "";
	
	private static int auto_ST_ID = 0;
	
	public Student(long st_ID, String name, String surname, String personID) {
		if(st_ID == -1) {
			this.st_ID = auto_ST_ID;
			auto_ST_ID++;
		}else {
			this.st_ID = st_ID;
		}
		setName(name);
		setSurname(surname);
		setPersonID(personID);
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
	public String getPersonID() {
		return personID;
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
	public void setPersonID(String personID) {
		if (personID != null && personID.matches("[0-9]{6}-[0-9]{6}")) {
			this.personID = personID;
		} else {
			this.personID = "000000-000000";
		}
		
	}
	
	@Override
	public String toString() {
		return "ID:" + st_ID + "\tNAME:" + name + " SURNAME:" + surname + " SURNAME:" + personID;
	}
}
