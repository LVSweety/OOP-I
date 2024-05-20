package lv.lvs.backend.model.customer;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lv.lvs.backend.model.parcel.Address;
import lv.lvs.backend.model.parcel.Parcel;
import lv.lvs.backend.model.person.Person;

@Table(name = "PrivateCustomer")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PrivateCustomer {
    @Column(name = "IdPC")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idPC;

    @Column(name = "CustomerCode")
    @NotNull
    private String customerCode;

    @Column(name = "PhoneNo")
    @NotNull
    @Pattern(regexp = "[0-9]{8}")
    private String phoneNo;

    @OneToOne
    @JoinColumn(name = "IdP")
    @JsonManagedReference
    private Person person;

    @ManyToOne
    @JoinColumn(name = "IdA")
    @JsonManagedReference
	private Address address;

    @OneToMany(mappedBy = "privateCustomer")
    @ToString.Exclude
    @JsonBackReference
	private Collection<Parcel> parcels;

    public PrivateCustomer(String phoneNo, Person person, Address address) {
        setPhoneNo(phoneNo);
        setPerson(person);
        setCustomerCode(person.getIdP() + "_person_" + person.getPersonCode());
        setAddress(address);
    }

}
