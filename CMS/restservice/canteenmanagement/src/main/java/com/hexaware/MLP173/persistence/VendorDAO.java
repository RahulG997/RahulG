package com.hexaware.MLP173.persistence;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.MLP173.model.Vendor;
/**
 * VendorDAO class used to fetch data from data base.
 * @author hexware
 */
public interface VendorDAO {
    /**
     * @return the all the Vendor record.
     */
  @SqlQuery("Select * from Vendor")
    @Mapper(VendorMapper.class)
    List<Vendor> show();
    /**
     * @param venName for reading Vendor Name.
     * @return vendor selected rows.
     */
  @SqlQuery("Select * from Vendor WHERE ven_NAME=:venName")
    @Mapper(VendorMapper.class)
    Vendor findByVendorName(@Bind("venName") String venName);
      /**
       * @param venName for accept Vendor Name
       * @param venPassword for accept vendor password.
       * @return count for authentication.
       */
  @SqlQuery("SELECT COUNT(*) FROM Vendor WHERE ven_NAME=:venName AND ven_PASSWORD=:venPassword")
     int authenticate(@Bind("venName") String venName, @Bind("venPassword") String venPassword);
}




