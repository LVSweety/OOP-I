package model.parcel;

import java.time.LocalDateTime;

import model.Driver;
import model.parcel.ParcelSize;

public class Parcel {
    private ParcelSize size;
    private LocalDateTime orderCreated;
    private LocalDateTime plannedDelivery;
    private boolean isFargile;
    private Driver driver;
    private float price;

    public Parcel() throws Exception {
        this.orderCreated = LocalDateTime.now(); 
    }
}
