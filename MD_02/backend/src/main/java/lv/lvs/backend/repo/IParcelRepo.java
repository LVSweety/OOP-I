package lv.lvs.backend.repo;

import java.util.ArrayList;

import org.antlr.v4.runtime.atn.SemanticContext.OR;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import lv.lvs.backend.model.parcel.City;
import lv.lvs.backend.model.parcel.Parcel;

public interface IParcelRepo extends CrudRepository<Parcel, Integer> {

    Parcel findByIdPA(int id);

    ArrayList<Parcel> findByDriverIdD(int id);

    ArrayList<Parcel> findByCompanyCustomerIdCCOrPrivateCustomerIdPC(int idCC, int idPC);

    ArrayList<Parcel> findByPriceBetween(float min, float max);

    @Query(value = "SELECT pt.* " +
            "FROM PARCEL_TABLE pt " +
            "LEFT JOIN COMPANY_CUSTOMER cc ON pt.IDCC = cc.IDCC " +
            "LEFT JOIN PRIVATE_CUSTOMER pc ON pt.IDPC = pc.IDPC " +
            "LEFT JOIN ADDRESS_TABLE at_cc ON cc.IDA = at_cc.IDA " +
            "LEFT JOIN ADDRESS_TABLE at_pc ON pc.IDA = at_pc.IDA " +
            "WHERE at_cc.CITY = :parcelCity OR at_pc.CITY = :parcelCity", nativeQuery = true)
    ArrayList<Parcel> findByCity(@Param("parcelCity") int city);

    @Query(value = "SELECT SUM(PRICE) " +
            "FROM PARCEL_TABLE pt " +
            "LEFT JOIN COMPANY_CUSTOMER cc ON pt.IDCC = cc.IDCC " +
            "LEFT JOIN PRIVATE_CUSTOMER pc ON pt.IDPC = pc.IDPC " +
            "WHERE cc.IDCC = :idC OR pc.IDPC = :idP", nativeQuery = true)
    float getIncome(@Param("idP") int idPC, @Param("idC") int idCC);

}
