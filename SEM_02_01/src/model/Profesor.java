package model;

public class Profesor extends Person{
	private long p_ID 		= 0;
	private Degree degree 	= Degree.OTHER;
	
	private static int auto_P_ID = 0;
	
	public Profesor(long p_ID, String name, String surname, Degree degree, String personID) {
		super(name,surname,personID);
		if(p_ID == -1) {
			this.p_ID = auto_P_ID;
			auto_P_ID++;
		}else {
			this.p_ID = p_ID;
		}
		setDegree(degree);
	}
	public Profesor() {
		super();
		this.p_ID = auto_P_ID;
		auto_P_ID++;
		this.degree = Degree.OTHER;
	}
	
	//GET
	public long getID() {
		return p_ID;
	}
	public Degree getDegree() {
		return degree;
	}
	//SET

	public void setDegree(Degree degree) {
		this.degree = degree;
	}
	
	@Override
	public String toString() {
		return "ID:" + p_ID + "\tNAME:" + super.getName() +  "\tSURNAME:" + super.getSurname() + "\tDEGREE:" + degree;
	}
}