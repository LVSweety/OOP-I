package lv.lvs.backend.model.parcel;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lv.lvs.backend.model.customer.CompanyCustomer;
import lv.lvs.backend.model.customer.PrivateCustomer;

@Table(name = "AddressTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Address {
    @Column(name = "IdA")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idA;
    
    @Column(name = "City")
    @NotNull
    private City city;

    @Column(name = "streetHouseTitle")
    @NotNull
    @Size(min = 2, max = 100)
    @Pattern(regexp = "[A-Z]{1}[a-z ]+")
    private String streetHouseTitle;

    @Column(name = "houseNo")
    @Min(0)
    private int houseNo;

    @OneToMany(mappedBy = "address")
    @ToString.Exclude
    @JsonBackReference
	private Collection<PrivateCustomer> customers;

    @OneToMany(mappedBy = "address")
    @ToString.Exclude
    @JsonBackReference
	private Collection<CompanyCustomer> companyCustomers;

    public Address(City city, String streetHouseTitle, int houseNo) {
        setCity(city);
        setHouseNo(houseNo);
        setStreetHouseTitle(streetHouseTitle);
    }
}
