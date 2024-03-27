package model.parcel;

import java.time.LocalDateTime;
import java.util.*; 

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
        setDriver(new Driver());
        setFargile(isFargile);
        setSize(ParcelSize.S);
        generatePrice();
    }

    public Parcel(boolean isFargile, ParcelSize parcelSize, LocalDateTime plannedDelivery, Driver driver) throws Exception {
        this.orderCreated = LocalDateTime.now(); 
        setPlannedDelivery(plannedDelivery);
        setDriver(driver);
        setFargile(isFargile);
        setSize(parcelSize);
        generatePrice();

    }

    private void generatePrice() {
        if (isFargile) {
            this.price = size(this.size)*(float)1.99 + (float)2.99;	
        } else {
            this.price = size(this.size)*(float)1.99;
        }
    }

    public void setPlannedDelivery(LocalDateTime plannedDelivery) throws Exception {
        if (plannedDelivery.compareTo(this.orderCreated) == 1){
            this.plannedDelivery = plannedDelivery;
            return;
        }
        throw new IllegalArgumentException("[ERROR]: invalid arguments"); 
    }

    public void setFargile(boolean isFargile) {
        this.isFargile = isFargile;
    }

    public void setSize(ParcelSize size) {
        this.size = size;
    }

    public void setPrice(float price) throws Exception {
        if (price > 0) {
            this.price = price;
            return;
        }
        throw new IllegalArgumentException("[ERROR]: invalid arguments"); 
    }

    public void setDriver(Driver driver) throws Exception {
        if (driver != null && driver instanceof Driver){
            this.driver = driver;
            return;
        }
        throw new IllegalArgumentException("[ERROR]: invalid arguments"); 
    }

    public float getPrice() {
        return price;
    }
    public ParcelSize getSize() {
        return size;
    }
    public LocalDateTime getOrderCreated() {
        return orderCreated;
    }
    public LocalDateTime getPlannedDelivery() {
        return plannedDelivery;
    }
    public Driver getDriver() {
        return driver;
    }
    public boolean getIsFargile() {
        return isFargile;
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

    public String toString() {
        return "[ " + this.size + " , " + this.orderCreated + " , " + this.plannedDelivery + " , " + this.isFargile + " , " + this.price + " , " + this.driver + " ]";
    }
}
