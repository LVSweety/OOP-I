package lv.lvs.backend.service;

import java.util.ArrayList;

import lv.lvs.backend.model.parcel.City;
import lv.lvs.backend.model.parcel.Parcel;

public interface IParcelHandlerService {
    
    public abstract ArrayList<Parcel> sellectAllParcel() throws Exception;

    public abstract Parcel sellectParcelByID(int id) throws Exception;
    
    public abstract ArrayList<Parcel> selectAllParcelByCustomerId(int idPC, int idCC) throws Exception;

    public abstract ArrayList<Parcel> selectAllParcelDeliveredByDriverId(int id) throws Exception;

    public abstract ArrayList<Parcel> selectAllParcelPriceRange(float min, float max) throws Exception;

    public abstract ArrayList<Parcel> selectAllParcelDeliveredToCity(City city) throws Exception;

    public abstract void deleteParcelByID(int id) throws Exception;

    //public abstract void insertNewParcelByCustomerCodeAndDriverId

    //public abstract void updateParcelDriverByParcelIdAndDriverId

    public abstract float calculateIncomeOfParcelsByCustomerId(int idPC, int idCC) throws Exception;

    public abstract int calculateHowManyParcelsNeedToDeliverToday() throws Exception;
}
