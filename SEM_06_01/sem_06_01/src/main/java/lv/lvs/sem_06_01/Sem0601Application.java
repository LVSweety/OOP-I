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
			ICourseRepo courseRepo, IGradeRepo grRepo)
	{
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Student st1 = new Student("Janis", "Berzins");
				Student st2 = new Student("Baiba", "Jauka");
				stuRepo.save(st1);
				stuRepo.save(st2);
				
				Profesor p1 = new Profesor("Karina", "Skirmante", Degree.MG);
				Profesor p2 = new Profesor("Vairis", "Caune", Degree.PHP);
				profRepo.save(p1);
				profRepo.save(p2);
				
				Course c1 = new Course("JAVA", 4, p1);
				Course c2 = new Course("Algoritmu teorija", 2, p2);
				courseRepo.save(c1);
				courseRepo.save(c2);
				
				Grade gr1 = new Grade(st1, c1, 6);
				Grade gr2 = new Grade(st1, c2, 9);
				Grade gr3 = new Grade(st2, c1, 10);
				grRepo.save(gr1);
				grRepo.save(gr2);
				grRepo.save(gr3);
				
			}
		};
	}

}


