package com.hexaware.MLP173.persistence;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.MLP173.model.Customer;
/**
 * CustomerDAO is used to c.
 * @author hexware.
 */
public interface CustomerDAO {
    /**
     * @return the all the Customer record.
     */
  @SqlQuery("Select * from Customer")
    @Mapper(CustomerMapper.class)
    List<Customer> show();
    /**
     * @param cusName for reading Customer Name.
     * @return customer selected rows.
     */
  @SqlQuery("Select * from CUSTOMER WHERE CUS_NAME=:cusName")
    @Mapper(CustomerMapper.class)
    Customer findByCustomerName(@Bind("cusName") String cusName);
      /**
       * @param cusName for accept Customer Name
       * @param cusPassword for accept customer password.
       * @return count for authentication.
       */
  @SqlQuery("SELECT COUNT(*) FROM CUSTOMER WHERE CUS_NAME=:cusName AND CUS_PASSWORD=:cusPassword")
     int authenticate(@Bind("cusName") String cusName, @Bind("cusPassword") String cusPassword);
}
