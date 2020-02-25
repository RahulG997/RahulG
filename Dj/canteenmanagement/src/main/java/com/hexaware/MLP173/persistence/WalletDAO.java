package com.hexaware.MLP173.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import com.hexaware.MLP173.model.Wallet;
/**
 * WalletDAO class used to fetch data from data base.
 * @author hexware
 */
public interface WalletDAO {
    /**
     * @return the all the Menu record.
     * @param cusId for showing customer id.
     */
  @SqlQuery("SELECT * FROM WALLET WHERE CUS_ID=:cusID ")
    @Mapper(WalletMapper.class)
    List<Wallet> showByWalletId(@Bind("cusID") int cusId);
   /**
     * @return the all the Wallet record.
     */
  @SqlQuery("SELECT * FROM WALLET")
    @Mapper(WalletMapper.class)
    List<Wallet> show();
}
