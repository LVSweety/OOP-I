package lv.lvs.backend.model.parcel;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lv.lvs.backend.model.customer.CompanyCustomer;
import lv.lvs.backend.model.customer.PrivateCustomer;
import lv.lvs.backend.model.driver.Driver;

@Table(name = "ParcelTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Parcel {
    @Column(name = "IdPA")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idPA;

    @Column(name = "IsFragile")
    private boolean isFragile;

    @Column(name = "OrderCreated")
    @NonNull
    private LocalDateTime orderCreated;

    @Column(name = "PlannedDelivery")
    @NonNull
    private LocalDateTime plannedDelivery;

    @Column(name = "Price")
    @Min(0)
    private float price;

    @Column(name = "Size")
    @NonNull
    private ParcelSize size;

    @ManyToOne
    @JoinColumn(name = "IdD")
    @JsonManagedReference
	private Driver driver;

    @ManyToOne
    @JoinColumn(name = "IdPC")
	private PrivateCustomer privateCustomer;
    
    @ManyToOne
    @JoinColumn(name = "IdCC")
	private CompanyCustomer companyCustomer;

    public Parcel(boolean isFargile, ParcelSize parcelSize, LocalDateTime plannedDelivery, Driver driver, PrivateCustomer privateCustomer, CompanyCustomer companyCustomer){
        setFragile(isFargile);
        setSize(parcelSize);
        setOrderCreated(LocalDateTime.now());
        setPlannedDelivery(plannedDelivery);
        setDriver(driver);
        setPrivateCustomer(privateCustomer);
        setCompanyCustomer(companyCustomer);
        postProcess();
    }

    private void postProcess(){
        if (this.isFragile) {
            setPrice(size(this.size)*(float)1.99 + (float)2.99);	
        } else {
            setPrice(size(this.size)*(float)1.99);
        }
    }

    private float size(ParcelSize size) {
        return switch (size) {
            case X -> 1;
            case S -> 2;
            case M -> 3;
            case L -> 4;
            case XL -> 5;
        };
    }
}
