package com.hexaware.MLP173.model;
import java.util.Objects;

/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Menu {
/**
 * foodId to store foodId.
 */
  private int foodId;
  /**
 * foodName to store Item Name.
 */
  private String foodName;
   /**
 * foodName to store Item details.
 */
  private double foodPrice;
 /**
 * foodName to store Item price.
 */
  private String foodDetail;
 /**
 * foodName to store Item Status.
 */
  private FoodStatus foodStatus;
 /**
 * foodName to store Item Rate.
 */
  private String foodRating;
  /**
   * Default Constructor.
   */
  public Menu() {

  }
/**
 * @param argfoodId to initialize food id.
 * @param argFoodName to initialize food Name.
 * @param argFoodPrice to initialize food price.
 * @param argFoodDetail to initialize food Detail.
 * @param argFoodStatus to initialize food Status.
 * @param argFoodRating to initialize food Rating.
 * used to get details through constructor.
 */
  public Menu(
      final int argfoodId, final String argFoodName, final String argFoodDetail,
      final double argFoodPrice, final FoodStatus argFoodStatus, final String argFoodRating) {
    this.foodId = argfoodId;
    this.foodName = argFoodName;
    this.foodDetail = argFoodDetail;
    this.foodPrice = argFoodPrice;
    this.foodStatus = argFoodStatus;
    this.foodRating = argFoodRating;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Menu menu = (Menu) obj;
    if (Objects.equals(foodId, menu.foodId)
        && Objects.equals(foodName, menu.foodName)
        && Objects.equals(foodDetail, menu.foodDetail)
        && Objects.equals(foodPrice, menu.foodPrice)
        && Objects.equals(foodStatus, menu.foodStatus)
        && Objects.equals(foodRating, menu.foodRating)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(foodId, foodName, foodDetail, foodPrice, foodStatus, foodRating);
  }
    /**
     * @return this food ID.
     */
  public final int getFoodId() {
    return foodId;
  }
    /**
     * @param argFoodId gets the food id.
     */
  public final void setFoodId(final int argFoodId) {
    this.foodId = argFoodId;
  }
      /**
     * @return this food ID.
     */
  public final double getFoodPrice() {
    return foodPrice;
  }
      /**
       * @param argFoodPrice gets the food id.
       */
  public final void setFoodPrice(final double argFoodPrice) {
    this.foodPrice = argFoodPrice;
  }
        /**
     * @return this food ID.
     */
  public final FoodStatus getFoodStatus() {
    return foodStatus;
  }
    /**
     * @param argFoodStatus gets the food id.
     */
  public final void setFoodStatus(final FoodStatus argFoodStatus) {
    this.foodStatus = argFoodStatus;
  }
      /**
     * @return this food ID.
     */
  public final String getFoodRating() {
    return foodRating;
  }
      /**
       * @param argFoodRating gets the food id.
       */
  public final void setFoodRating(final String argFoodRating) {
    this.foodRating = argFoodRating;
  }
       /**
     * @return this food ID.
     */
  public final String getFoodDetail() {
    return foodDetail;
  }
      /**
       * @param argFoodDetail gets the food id.
       */
  public final void setFoodDetail(final String argFoodDetail) {
    this.foodDetail = argFoodDetail;
  }

  /**
     * @return this food Item Name.
     */
  public final String getFoodName() {
    return foodName;
  }
      /**
       * @param argFoodName gets the food Name.
       */
  public final void setFoodName(final String argFoodName) {
    this.foodName = argFoodName;
  }
  @Override
  public final String toString() {
    return String.format("%-15s %-25s %-15s %-15s %-15s %-15s", foodId, foodName, foodPrice, foodStatus, foodDetail, foodRating);
  }
}
