package lv.lvs.backend.model.driver;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lv.lvs.backend.model.parcel.Parcel;
import lv.lvs.backend.model.person.Person;

@Table(name = "DriverTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Driver {
    @Column(name = "IdD")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idD;

    @Column(name = "ExperienceInYears")
    @Min(0)
    private float experienceInYears;
    
    @Column(name = "LicenseNo")
    @NotNull
    @Pattern(regexp = "[A-Z]{2}[0-9]{6}")
    private String licenseNo;

    @OneToOne
    @JoinColumn(name = "IdP")
    @JsonManagedReference
    private Person person;

    @OneToMany(mappedBy = "driver")
    @ToString.Exclude
    @JsonBackReference
	private Collection<Parcel> parcels;

    public Driver(float experienceInYears, String licenseNo, Person person) {
        setLicenseNo(licenseNo);
        setExperienceInYears(experienceInYears);
        setPerson(person);
    }
}   
