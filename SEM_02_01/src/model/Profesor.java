package model;

public class Profesor {
	private long p_ID 		= 0;
	private String name 	= "";
	private String surname 	= "";
	private Degree degree 	= Degree.OTHER;
	
	private static int auto_P_ID = 0;
	
	public Profesor(long p_ID, String name, String surname, Degree degree) {
		if(p_ID == -1) {
			this.p_ID = auto_P_ID;
			auto_P_ID++;
		}else {
			this.p_ID = p_ID;
		}
		setName(name);
		setSurname(surname);
		setDegree(degree);
	}
	public Profesor() {
		this.p_ID = auto_P_ID;
		auto_P_ID++;
		this.name = "NULL";
		this.surname = "NULL";
		this.degree = Degree.OTHER;
	}
	
	//GET
	public long getID() {
		return p_ID;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public Degree getDegree() {
		return degree;
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
	public void setDegree(Degree degree) {
		this.degree = degree;
	}
	
	@Override
	public String toString() {
		return "ID:" + p_ID + "\tNAME:" + name + " SURNAME:" + surname + " DEGREE:" + degree;
	}
}