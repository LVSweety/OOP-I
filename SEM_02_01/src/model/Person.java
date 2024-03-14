package model;

public class Person {
	private String name 	= "";
	private String surname 	= "";
	private String personID = "";
	
	
	public Person (String name, String surname, String personID) {
		setName(name);
		setSurname(surname);
		setPersonID(personID);
	}
	public Person() {
		this.name 		= "NULL";
		this.surname 	= "NULL";
		this.personID	= "000000-000000";
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
	
	//GET
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getPersonID() {
		return personID;
	}

}