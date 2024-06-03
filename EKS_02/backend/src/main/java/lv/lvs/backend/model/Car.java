package lv.lvs.backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Table(name = "CarTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Car {
    @Column(name = "IdCA")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idCA;

    @Column(name = "ModelYear")
	@Min(0)
	private int modelYear;

    @Column(name = "Manufacturer")
	@NotNull
	@Size(min = 2, max = 40)
	private String manufacturer;

    @Column(name = "Model")
	@NotNull
	@Size(min = 2, max = 40)
	private String model;

    @ManyToOne
    @JoinColumn(name = "IdC")
    @JsonManagedReference
    private Customer customer;

    public Car(int modelYear, String manufacturer, String model, Customer customer) {
        setModelYear(modelYear);
        setManufacturer(manufacturer);
        setModel(model);
        setCustomer(customer);
    }
}
