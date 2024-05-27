package lv.lvs.sem_06_01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.lvs.sem_06_01.model.Course;
import lv.lvs.sem_06_01.model.Grade;
import lv.lvs.sem_06_01.model.Profesor;
import lv.lvs.sem_06_01.model.Student;
import lv.lvs.sem_06_01.model.properties.Degree;
import lv.lvs.sem_06_01.repo.IStudentRepo;
import lv.lvs.sem_06_01.repo.ICourseRepo;
import lv.lvs.sem_06_01.repo.IGradeRepo;
import lv.lvs.sem_06_01.repo.IProfesorRepo;

@SpringBootApplication
public class Sem0601Application {

	public static void main(String[] args) {
		SpringApplication.run(Sem0601Application.class, args);
	}

	@Bean
	public CommandLineRunner testDatabaseLayer(IProfesorRepo profRepo, IStudentRepo stuRepo, 
			ICourseRepo courseRepo, IGradeRepo gradeRepo)
	{
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Student st1 = new Student("Janis", "Berzins");
				Student st2 = new Student("Baiba", "Jauka");
				Student st3 = new Student("Ralfs", "Upe");
				Student st4 = new Student("Aigars", "Stiga");
				stuRepo.save(st1);
				stuRepo.save(st2);
				stuRepo.save(st3);
				stuRepo.save(st4);
				
				Profesor p1 = new Profesor("Karina", "Skirmante", Degree.MG);
				Profesor p2 = new Profesor("Vairis", "Caune", Degree.PHP);
				profRepo.save(p1);
				profRepo.save(p2);
				
				Course c1 = new Course("JAVA", 4, p1, p2);
				Course c2 = new Course("Algoritmu teorija", 2, p1);
				courseRepo.save(c1);
				courseRepo.save(c2);
				
				Grade g1 = new Grade(st1, c1, 10);
				Grade g2 = new Grade(st1, c2, 9);
				Grade g3 = new Grade(st2, c1, 8);
				Grade g4 = new Grade(st2, c2, 3);
				Grade g5 = new Grade(st3, c1, 7);
				Grade g6 = new Grade(st3, c2, 4);
				Grade g7 = new Grade(st4, c1, 3);
				Grade g8 = new Grade(st4, c2, 1);
				gradeRepo.save(g1);
				gradeRepo.save(g2);
				gradeRepo.save(g3);
				gradeRepo.save(g4);
				gradeRepo.save(g5);
				gradeRepo.save(g6);
				gradeRepo.save(g7);
				gradeRepo.save(g8);

				p1.addCourse(c1);
				p2.addCourse(c1);
				p1.addCourse(c2);
				
				profRepo.save(p1);
				profRepo.save(p2);
			}
		};
	}

}


