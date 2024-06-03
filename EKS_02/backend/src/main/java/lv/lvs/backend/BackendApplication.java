package lv.lvs.backend;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.lvs.backend.model.Car;
import lv.lvs.backend.model.Customer;
import lv.lvs.backend.model.MaintenanceProcedure;
import lv.lvs.backend.model.Mechanic;
import lv.lvs.backend.model.MechanicType;
import lv.lvs.backend.repo.ICarRepo;
import lv.lvs.backend.repo.ICustomerRepo;
import lv.lvs.backend.repo.IMaintenanceProcedureRepo;
import lv.lvs.backend.repo.IMechanicRepo;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner testDatabaseLayer(ICustomerRepo customerRepo, ICarRepo carRepo, IMechanicRepo mechanicRepo, IMaintenanceProcedureRepo maintenanceProcedureRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Customer c1 = new Customer("Janis", "Berzins");
				Customer c2 = new Customer("Baiba", "Ziemite");
				customerRepo.save(c1);
				customerRepo.save(c2);

				Car ca1 = new Car(2023, "Golf", "WV", c1);
				Car ca2 = new Car(2020, "A160", "MB", c2);
				Car ca3 = new Car(2015, "X60", "BMW", c2);
				carRepo.save(ca1);
				carRepo.save(ca2);
				carRepo.save(ca3);

				Mechanic m1 = new Mechanic("Kaspars", "Dzinejs", MechanicType.ENGINE);
				Mechanic m2 = new Mechanic("Janis", "Riepa", MechanicType.TYRES);
				mechanicRepo.save(m1);
				mechanicRepo.save(m2);

				MaintenanceProcedure mp1 = new MaintenanceProcedure(LocalDateTime.now(), ca1, m2);
				MaintenanceProcedure mp2 = new MaintenanceProcedure(LocalDateTime.now(), ca3, m1);
				MaintenanceProcedure mp3 = new MaintenanceProcedure(LocalDateTime.now(), ca3, m2);
				MaintenanceProcedure mp4 = new MaintenanceProcedure(LocalDateTime.now(), ca2, m1);
				maintenanceProcedureRepo.save(mp1);
				maintenanceProcedureRepo.save(mp2);
				maintenanceProcedureRepo.save(mp3);
				maintenanceProcedureRepo.save(mp4);
			}	
		};
	}

}
