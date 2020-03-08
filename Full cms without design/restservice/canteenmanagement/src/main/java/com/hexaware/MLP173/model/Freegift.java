package com.hexaware.MLP173.model;
public class Freegift {
    
    private int cusId;
    private int venId;
    private int status;

    public Freegift(){

    }
    /**
     *  @param argCusId to initialize menu Name.
 * @param argVenId to initialize menu id.
 * @param argCount to initialize menu price.
 */
  public Freegift(final int argCusId, final int argVenId, final int argStatus) {
this.cusId = argCusId;
this.venId = argVenId;
this.status = argStatus;
}
        /**
     * @return this vendor ID.
     */
  public final int getCusId() {
    return cusId;
  }
    /**
     * @param argCusId gets the food id.
     */
  public final void setCusId(final int argCusId) {

    this.cusId = argCusId;
  }

          /**
     * @return this cgst.
     */
    public final int getVenId() {
        return venId;
      }
        /**
         * @param argVenId gets the food id.
         */
      public final void setVenId(final int argVenId) {
    
        this.venId = argVenId;
      }
             /**
     * @return this cgst.
     */
    public final int getStatus() {
        return status;
      }
        /**
         * @param argStatus gets the food id.
         */
      public final void setStatus(final int argStatus) {
    
        this.status = getStatus();
      }
}
