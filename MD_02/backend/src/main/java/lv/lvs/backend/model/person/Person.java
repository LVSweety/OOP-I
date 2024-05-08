package lv.lvs.backend.model.person;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lv.lvs.backend.model.customer.PrivateCustomer;
import lv.lvs.backend.model.driver.Driver;

@Table(name = "PersonTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Person {
    @Column(name = "IdP")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idP;

    @Column(name = "Name")
	@NotNull
	@Size(min = 2, max = 20)
	@Pattern(regexp = "[A-Z]{1}[a-z]+")
	private String name;
	
	@Column(name = "Surname")
	@NotNull
	@Size(min = 2, max = 40)
	@Pattern(regexp = "[A-Z]{1}[a-z]+") 
	private String surname;

    @Column(name = "PersonCode")
	@NotNull
	@Size(min = 2, max = 40)
	@Pattern(regexp = "[0-9]{6}-[0-9]{5}") 
	private String personCode;

    @OneToOne(mappedBy = "person")
	@ToString.Exclude
	@JsonBackReference
	private Driver driver;

    @OneToOne(mappedBy = "person")
	@ToString.Exclude
	@JsonBackReference
	private PrivateCustomer privateCustomer;

    public Person(String name, String surname, String personCode){
        setName(name);
        setSurname(surname);
        setPersonCode(personCode);
    }
}
