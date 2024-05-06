package lv.lvs.backend;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.lvs.backend.model.customer.CompanyCustomer;
import lv.lvs.backend.model.customer.PrivateCustomer;
import lv.lvs.backend.model.driver.Driver;
import lv.lvs.backend.model.parcel.Address;
import lv.lvs.backend.model.parcel.City;
import lv.lvs.backend.model.parcel.Parcel;
import lv.lvs.backend.model.parcel.ParcelSize;
import lv.lvs.backend.model.person.Person;
import lv.lvs.backend.repo.IAddressRepo;
import lv.lvs.backend.repo.ICompanyCustomerRepo;
import lv.lvs.backend.repo.IDriverRepo;
import lv.lvs.backend.repo.IParcelRepo;
import lv.lvs.backend.repo.IPersonRepo;
import lv.lvs.backend.repo.IPrivateCustomerRepo;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner testDatabaseLayer(IPersonRepo personRepo, IAddressRepo addressRepo, IDriverRepo driverRepo, IPrivateCustomerRepo privateCustomerRepo, ICompanyCustomerRepo companyCustomerRepo, IParcelRepo parcelRepo){
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Person p1 = new Person("Janis", "Lapa", "123456-12345");
				Person p2 = new Person("Juris", "Upe", "840385-94853");
				Person p3 = new Person("Toms", "Liepa", "046821-04927");
				Person p4 = new Person("Davids", "Upe", "945821-83921");
				personRepo.save(p1);
				personRepo.save(p2);
				personRepo.save(p3);
				personRepo.save(p4);

				Address a1 = new Address(City.RIGA, "Jelgavas", 52);
				Address a2 = new Address(City.LIEPAJA, "Austras", 7);
				Address a3 = new Address(City.DAUGAVPILS, "Upes", 42);
				Address a4 = new Address(City.LIEPAJA, "Zemgales", 32);
				Address a5 = new Address(City.JELGAVA, "Saules", 12);
				Address a6 = new Address(City.JELGAVA, "Pils", 11);
				Address a7 = new Address(City.VENTSPILS, "Sakas", 4);
				Address a8 = new Address(City.RIGA, "Akmens", 23);
				addressRepo.save(a1);
				addressRepo.save(a2);
				addressRepo.save(a3);
				addressRepo.save(a4);
				addressRepo.save(a5);
				addressRepo.save(a6);
				addressRepo.save(a7);
				addressRepo.save(a8);

				Driver d1 = new Driver(1, "AL123456", p1);
				Driver d2 = new Driver(20, "AL849532", p2);
				driverRepo.save(d1);
				driverRepo.save(d2);

				Person p5 = new Person("Aigars", "Liepa", "046821-04927");
				Person p6 = new Person("Varis", "Upe", "945821-83921");
				personRepo.save(p5);
				personRepo.save(p6);
				PrivateCustomer pc1 = new PrivateCustomer("12345678", p3, a1);
				PrivateCustomer pc2 = new PrivateCustomer("27345493", p4, a2);
				PrivateCustomer pc3 = new PrivateCustomer("14734967", p5, a3);
				PrivateCustomer pc4 = new PrivateCustomer("40582749", p6, a3);
				privateCustomerRepo.save(pc1);
				privateCustomerRepo.save(pc2);
				privateCustomerRepo.save(pc3);
				privateCustomerRepo.save(pc4);

				CompanyCustomer cc1 = new CompanyCustomer("68574354", "LV12345678901", "SIA ABC", a8);
				companyCustomerRepo.save(cc1);
				cc1.postProcess();
				companyCustomerRepo.save(cc1);
				CompanyCustomer cc2 = new CompanyCustomer("96584345", "LV86594034564", "SIA absolute", a8);
				companyCustomerRepo.save(cc2);
				cc2.postProcess();
				companyCustomerRepo.save(cc2);

				Parcel pr1 = new Parcel(true, ParcelSize.L, LocalDateTime.now(), d1, null, cc1);
				Parcel pr2 = new Parcel(true, ParcelSize.L, LocalDateTime.now(), d1, null, cc2);
				Parcel pr3 = new Parcel(false, ParcelSize.L, LocalDateTime.now(), d2, pc1, null);
				Parcel pr4 = new Parcel(true, ParcelSize.L, LocalDateTime.now(), d1,  pc1, null);
				parcelRepo.save(pr1);
				parcelRepo.save(pr2);
				parcelRepo.save(pr3);
				parcelRepo.save(pr4);

			}	
		};
	}
}


