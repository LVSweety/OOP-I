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
	}

}
