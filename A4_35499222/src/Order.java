import java.util.List;

public class Order {
    private String customerName;
    private String phoneNumber;
    private String address;
    private List<FoodItem> items;
    private double totalCost;
    private MealType mealType;

    public Order(String customerName, String phoneNumber, String address, List<FoodItem> items) {
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.items = items;
        calculateTotalAndMealType();
    }

    private void calculateTotalAndMealType() {
        totalCost = 0;
        boolean hasMeat = false;
        boolean hasVegetarian = false;

        for (FoodItem item : items) {
            totalCost += item.getTotalPrice();
            MealType type = item.getMealType();
            if (type == MealType.MEAT) {
                hasMeat = true;
            } else if (type == MealType.VEGETARIAN) {
                hasVegetarian = true;
            }
        }

        if (hasMeat) mealType = MealType.MEAT;
        else if (hasVegetarian) mealType = MealType.VEGETARIAN;
        else mealType = MealType.VEGAN;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public MealType getMealType() {
        return mealType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer: ").append(customerName)
                .append(" | Phone: ").append(phoneNumber)
                .append(" | Address: ").append(address)
                .append(" | Meal Type: ").append(mealType)
                .append(" | Total: $").append(String.format("%.2f", totalCost))
                .append("\nItems:\n");

        for (FoodItem item : items) {
            sb.append("- ").append(item.toString()).append(" | Meal Type: ").append(mealType);
        }

        return sb.toString();
    }
}
