package com.hexaware.MLP173.model;
import java.util.Objects;
/**
 * Wallet class used to display Wallet information.
 * @author hexware
 */
public class Wallet {
/**
 * walid  to store WalletId.
 */
  private int cusId;
    /**
 * walid  to store WalletId.
 */
  private int walId;
  /**
 * walamount to store Wallet amount.
 */
  private int walAmount;
/**
 * waltype to store Wallet Type.
 */
  private WalType walType;
 /**
   * Default Constructor.
   */
  public Wallet() {

  }
/**
 * @param argCusId to initialize WalletId.
 * @param argWalId to initialize WalletId.
 * @param argWalAmount to initialize Walletamount.
 * @param argWalType to initialize Wallet type.
 * used to get details through constructor.
 */
  public Wallet(final int argCusId, final int argWalId, final int argWalAmount, final WalType argWalType) {
    this.cusId = argCusId;
    this.walId = argWalId;
    this.walAmount = argWalAmount;
    this.walType = argWalType;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Wallet wallet = (Wallet) obj;
    if (Objects.equals(walId, wallet.walId)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(walId);
  }
  /**
     * @return this Wallet ID.
     */
  public final int getCusId() {
    return cusId;
  }
        /**
         * @param argCusId gets the wallet id.
         */
  public final void setCusId(final int argCusId) {
    this.cusId = argCusId;
  }
    /**
     * @return this Wallet ID.
     */
  public final int getWalId() {
    return walId;
  }
    /**
     * @param argWalId gets the wallet id.
     */
  public final void setWalId(final int argWalId) {
    this.walId = argWalId;
  }
      /**
     * @return this food ID.
     */
  public final WalType getWalType() {
    return walType;
  }
      /**
       * @param argWalType gets the type of wallet.
       */
  public final void setWalType(final WalType argWalType) {
    this.walType = argWalType;
  }
        /**
     * @return this food ID.
     */
  public final int getWalAmount() {
    return walAmount;
  }
          /**
           * @param argWalAmount gets the type of wallet.
           */
  public final void setWalType(final int argWalAmount) {
    this.walAmount = argWalAmount;
  }
}


