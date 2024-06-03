package lv.lvs.backend.model;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Table(name = "CustomerTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Customer {
    @Column(name = "IdC")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idC;
    
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

    @OneToMany(mappedBy = "customer")
    @ToString.Exclude
    @JsonBackReference
	private Collection<Car> cars;

    public Customer(String name, String surname){
        setName(name);
        setSurname(surname);
    }
}
