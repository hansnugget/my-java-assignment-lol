public abstract class FoodItem {
    protected final double basePrice = 11.50;

    public abstract double getTotalPrice();
    public abstract MealType getMealType(); //meat, vegetarian, vegan enum to prevent typo

    public double getBasePrice() {
        return basePrice;
    }
}
