package lv.lvs.backend.model.customer;

import java.util.Collection;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lv.lvs.backend.model.parcel.Address;
import lv.lvs.backend.model.parcel.Parcel;

@Table(name = "CompanyCustomer")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CompanyCustomer {
    @Column(name = "IdCC")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idCC;

    @Column(name = "CustomerCode")
    @Setter(value = AccessLevel.NONE)
    private String customerCode;

    @Column(name = "PhoneNo")
    @NotNull
    @Pattern(regexp = "[0-9]{8}")
    private String phoneNo;

    @Column(name = "RegistrationNo")
    @NonNull
    @Pattern(regexp = "LV[0-9]{11}")
    private String regNo;

    @Column(name = "Title")
    @NonNull
    @Size(min = 5, max = 100)
    private String title;

    @ManyToOne
    @JoinColumn(name = "IdA")
	private Address address;

    @OneToMany(mappedBy = "companyCustomer")
    @ToString.Exclude
	private Collection<Parcel> parcels;

    public CompanyCustomer(String phoneNo, String regNo, String title, Address address){
        setPhoneNo(phoneNo);
        setRegNo(regNo);
        setAddress(address);
        setTitle(title);
    }

    public void postProcess(){
        this.customerCode = this.getIdCC() + "_company_" + this.getRegNo();
    }
}
