package model;

public class Grade {
	private long g_ID 		= 0;
	private int value 		= 0;
	private Student student = null;
	private Course course 	= null;
	
	private static int auto_G_ID = 0;
	
	public Grade(long g_ID, int value, Student student, Course course) {
		if(g_ID == -1) {
			this.g_ID = auto_G_ID;
			auto_G_ID++;
		}else {
			this.g_ID = g_ID;
		}
		setValue(value);
		setStudent(student);
		setCourse(course);
	}
	public Grade() {
		this.g_ID = auto_G_ID;
		auto_G_ID++;
		setValue(0);
		this.student 	= null;
		this.course 	= null;
	}
	
	//GET
	public long getG_ID() {
		return g_ID;
	}
	public int getValue() {
		return value;
	}
	public Student getStudent() {
		return student;
	}
	public Course getCourse() {
		return course;
	}
	//SET
	public void setValue(int value) {
		if (value >= 0 && value <= 10) {
			this.value = value;
		}else {
			this.value = 0;
		}
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	@Override
	public String toString() {
		return "DEF STRING";
	}
}
