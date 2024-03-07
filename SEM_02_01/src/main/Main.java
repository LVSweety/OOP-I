package main;

import java.util.ArrayList;

import model.Course;
import model.Degree;
import model.Grade;
import model.Profesor;
import model.Student;

public class Main {

	private static ArrayList<Profesor> Profesors = new ArrayList<Profesor>();
	private static ArrayList<Student> Students = new ArrayList<Student>();
	private static ArrayList<Course> Courses = new ArrayList<Course>();
	private static ArrayList<Grade> Grades = new ArrayList<Grade>();
	
	public static void main(String[] args) {
		Profesors.add(new Profesor(-1, "Andris", "Liepa", Degree.MG));	
		Profesors.add(new Profesor(-1, "Artis", "Virpa", Degree.MG));
		for(Profesor e : Profesors) {
			System.out.println(e);
		}
		
		try {
			createEntry("Varis", "Upe", "839285-985345");
			createEntry("Juris", "Kalns", "644185-985345");
			createEntry("Varis", "Upe", "839285-985345");
			createEntry("Juris", "Kalns", "644185-985345");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		for(Student e : Students) {
			System.out.println(e);
		}
		
		Courses.add(new Course(-1, "EIGP II", 6, Profesors.get(0)));	
		Courses.add(new Course(-1, "IOS", 1, Profesors.get(0)));
		Courses.add(new Course(-1, "ANT", 4, Profesors.get(0)));
		Courses.add(new Course(-1, "EIP I", 4, Profesors.get(1)));
		for(Course e : Courses) {
			System.out.println(e.getProfesor());
		}
		
		Grades.add(new Grade(-1, 5, Students.get(0), Courses.get(0)));	
		Grades.add(new Grade(-1, 6, Students.get(0), Courses.get(1)));
		Grades.add(new Grade(-1, 6, Students.get(1), Courses.get(0)));
		Grades.add(new Grade(-1, 9, Students.get(1), Courses.get(1)));
		for(Grade e : Grades) {
			System.out.println(e.getStudent());
		}

		try {
			System.out.println(averageGrde(Students.get(0)));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			System.out.println(averageGrdeCourse(Courses.get(1)));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			System.out.println(profesorCourses(Profesors.get(0)));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public static float averageGrde(Student student) throws Exception {
		if (student == null) throw new Exception("Undefined argument");
		
		float sum = 0;
		float points = 0;
		
		for(Grade e : Grades) {
			if (e.getStudent().equals(student)) {
				sum = sum + e.getCourse().getCreditPoints()*e.getValue();
				points = points + e.getCourse().getCreditPoints();
			}
		}
		if (points == 0) {
			return 0;
		} else {
			return sum/points;
		}
		
	}
	
	public static float averageGrdeCourse(Course course) throws Exception {
		if (course == null) throw new Exception("Undefined argument");
		
		float sum = 0;
		float points = 0;
		
		for(Grade e : Grades) {
			if (e.getCourse().equals(course)) {
				sum = sum + e.getValue();
				points++;
			}
		}
		if (points == 0) {
			return 0;
		} else {
			return sum/points;
		}
		
	}
	
	public static int profesorCourses(Profesor profesor) throws Exception {
		if (profesor == null) throw new Exception("Undefined argument");
		
		int sum = 0;
		
		for(Course e : Courses) {
			if (e.getProfesor().equals(profesor)) {
				sum++;
			}
		}
		return sum;
		
	}
	
	public static void createEntry(String name, String surname, String personCode) 
			throws Exception  {
		if(name == null || surname == null || personCode == null) {
			throw new Exception("Problems with input arguments");
		}
		
		
		for(Student tempSt: Students) {
			if(tempSt.getPersonID().equals(personCode)) {
				throw new Exception(tempSt.getName() +" " + tempSt.getSurname()
				+ " is already regeisterd in the system");
			}
		}
		Students.add(new Student(-1, name, surname, personCode));
		
		
	}
}
