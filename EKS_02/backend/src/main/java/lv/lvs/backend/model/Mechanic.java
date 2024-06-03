package lv.lvs.backend.model;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Table(name = "MechanicTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Mechanic {
    @Column(name = "IdM")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idM;

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

    @Column(name = "Type")
	@NotNull
	private MechanicType type;

    @OneToMany(mappedBy = "mechanic")
    @ToString.Exclude
    @JsonBackReference
	private Collection<MaintenanceProcedure> maintenanceProcedures;

    public Mechanic(String name, String surname, MechanicType type) {
        setName(surname);
        setSurname(surname);
        setType(type);
    }
}
