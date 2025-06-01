public class Pasta extends FoodItem {
    private String toppings;

    public Pasta(String topping) {
        this.toppings = topping.toLowerCase();
    }

    @Override
    public double getTotalPrice() {
        switch (toppings) {
            case "tomato": return basePrice + 4;
            case "bolognese":
            case "primavera": return basePrice + 5.20;
            case "marinara": return basePrice + 6.80;
            default: return basePrice; //if topping is unavailable or unrecognised
        }
    }

    @Override
    public MealType getMealType() {
        switch (toppings.toLowerCase()) {
            case "bolognese":
            case "marinara":
                return MealType.MEAT;
            case "primavera":
                return MealType.VEGETARIAN;
            case "tomato":
            default:
                return MealType.VEGAN;
        }
    }

    @Override
    public String toString() {
        return "Pasta with toppings: " + toppings + " | Type: " + getMealType() + " | Price: $" + getTotalPrice();
    }
}
