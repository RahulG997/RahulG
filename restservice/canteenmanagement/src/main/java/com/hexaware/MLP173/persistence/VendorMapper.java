package com.hexaware.MLP173.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

//import com.hexaware.MLP173.model.FoodStatus;
import com.hexaware.MLP173.model.Vendor;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * VendorMapper class used to fetch Vendor data from database.
 * @author hexware
 */
public class VendorMapper implements ResultSetMapper<Vendor> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Vendor map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Vendor
       */
    // String status = rs.getString("FOOD_STATUS");
    // FoodStatus fstatus = FoodStatus.valueOf(status);
    return new Vendor(rs.getInt("VEN_ID"), rs.getString("VEN_NAME"), rs.getString("VEN_PASSWORD"),
    rs.getString("VEN_EMAIL"), rs.getString("VEN_MOBILE"), rs.getString("VEN_ADDRESS"));
  }
}
