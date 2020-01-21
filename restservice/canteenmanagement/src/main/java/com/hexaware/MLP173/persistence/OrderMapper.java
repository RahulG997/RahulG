package com.hexaware.MLP173.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP173.model.OrderStatus;
import com.hexaware.MLP173.model.OrderDetail;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * MenuMapper class used to fetch menu data from database.
 * @author hexware
 */
public class OrderMapper implements ResultSetMapper<OrderDetail> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final OrderDetail map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return OrderDetail
       */
    String status = rs.getString("ORD_STATUS");
    OrderStatus ostatus = OrderStatus.valueOf(status);
    return new OrderDetail(rs.getInt("ORDER_ID"), rs.getDate("ORD_TIME"), rs.getDouble("ORD_AMOUNT"),
    rs.getString("ORD_LOCATION"), ostatus, rs.getInt("QTY_ORDER"),
    rs.getInt("CUS_ID"), rs.getInt("FOOD_ID"), rs.getInt("VEN_ID"), rs.getString("WAL_TYPE"),
    rs.getString("ORD_COMMENTS"));
  }
}
