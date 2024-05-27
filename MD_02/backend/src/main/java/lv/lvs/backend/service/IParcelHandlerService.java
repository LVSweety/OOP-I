package lv.lvs.backend.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import lv.lvs.backend.model.parcel.City;
import lv.lvs.backend.model.parcel.Parcel;
import lv.lvs.backend.model.parcel.ParcelSize;

public interface IParcelHandlerService {
    
    public abstract ArrayList<Parcel> sellectAllParcel() throws Exception;

    public abstract Parcel sellectParcelByID(int id) throws Exception;
    
    public abstract ArrayList<Parcel> selectAllParcelByCustomerId(int idPC, int idCC) throws Exception;

    public abstract ArrayList<Parcel> selectAllParcelDeliveredByDriverId(int id) throws Exception;

    public abstract ArrayList<Parcel> selectAllParcelPriceRange(float min, float max) throws Exception;

    public abstract ArrayList<Parcel> selectAllParcelDeliveredToCity(City city) throws Exception;

    public abstract void deleteParcelByID(int id) throws Exception;

    public void insertNewParcel(LocalDateTime plannedDelivery, ParcelSize size, boolean fragile, String customerCode, int idD) throws Exception;

    public void updateParcelByID(int id, LocalDateTime orderCreated, LocalDateTime plannedDelivery, float price, ParcelSize size, boolean fragile, String customerCode, int idD) throws Exception;

    public abstract float calculateIncomeOfParcelsByCustomerId(int idPC, int idCC) throws Exception;

    public abstract int calculateHowManyParcelsNeedToDeliverToday() throws Exception;
}
