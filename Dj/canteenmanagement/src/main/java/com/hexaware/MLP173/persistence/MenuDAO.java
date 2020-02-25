package com.hexaware.MLP173.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import com.hexaware.MLP173.model.Menu;
/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface MenuDAO {
    /**
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from FOOD_ITEM")
    @Mapper(MenuMapper.class)
    List<Menu> show();
    /**
     * @param foodId for reading menuid.
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from FOOD_ITEM WHERE FOOD_ID=:foodId")
  @Mapper(MenuMapper.class)
  Menu show(@Bind("foodId") int foodId);
}
