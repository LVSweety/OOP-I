package model;

public class Course {
	private long c_ID 			= 0;
	private String title 		= "";
	private int creditPoints 	= 0;
	private Profesor profesor 	= null;
	
	private static int auto_C_ID = 0;
	
	public Course(long c_ID, String title, int creditPoints, String surname, Profesor profesor) {
		if(c_ID == -1) {
			this.c_ID = auto_C_ID;
			auto_C_ID++;
		}else {
			this.c_ID = c_ID;
		}
		setTitle(title);
		setCreditPoints(creditPoints);
		setProfesor(profesor);
	}
	public Course() {
		this.c_ID 			= auto_C_ID;
		auto_C_ID ++;
		this.title 			= "NULL";
		setCreditPoints(0);
		setProfesor(null);
	}
	
	//GET
	public long getID() {
		return c_ID;
	}
	public String getTitle() {
		return title;
	}
	public int getCreditPoints() {
		return creditPoints;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	//SET
	public void setTitle(String title) {
		if(title != null && title.matches("[A-Z]{1}[a-z]+(( [A-z]+)?)+")){
			this.title = title;
		}else {
			this.title = "NULL";
		}
		this.title = title;
	}
	public void setCreditPoints(int creditPoints) {
		if(creditPoints >= 0) {
			this.creditPoints = creditPoints;
		}else{
			this.creditPoints = 0;
		}
		
	}
	public void setProfesor(Profesor profestor) {
		this.profesor = profestor;
	}
	
	@Override
	public String toString() {
		return "DEF STRING";
	}
}
