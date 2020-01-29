package com.hexaware.MLP173.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

//import com.hexaware.MLP173.model.FoodStatus;
import com.hexaware.MLP173.model.Customer;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * CustomerMapper class used to fetch Customer data from database.
 * @author hexware
 */
public class CustomerMapper implements ResultSetMapper<Customer> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Customer map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Customer
       */
    // String status = rs.getString("FOOD_STATUS");
    // FoodStatus fstatus = FoodStatus.valueOf(status);
    return new Customer(rs.getInt("CUS_ID"), rs.getString("CUS_NAME"), rs.getString("CUS_PASSWORD"),
    rs.getString("CUS_EMAIL"), rs.getString("CUS_MOBILE"), rs.getDate("CUS_DOB"), rs.getString("CUS_ADDRESS"));
  }
}
