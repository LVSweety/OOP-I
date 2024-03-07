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
		
		Students.add(new Student(-1, "Varis", "Upe"));	
		Students.add(new Student(-1, "Juris", "Kalns"));
		for(Student e : Students) {
			System.out.println(e);
		}
		
		Courses.add(new Course(-1, "EIGP II", 6, Profesors.get(0)));	
		Courses.add(new Course(-1, "EIP I", 2, Profesors.get(1)));
		for(Course e : Courses) {
			System.out.println(e.getProfesor());
		}
		
		Grades.add(new Grade(-1, 5, Students.get(0), Courses.get(0)));	
		Grades.add(new Grade(-1, 3, Students.get(1), Courses.get(1)));
		for(Grade e : Grades) {
			System.out.println(e.getStudent());
		}
	}

}
