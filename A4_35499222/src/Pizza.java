import java.util.List;

public class Pizza extends FoodItem {
    private List<String> toppings;

    public Pizza(List<String> toppings) {
        this.toppings = toppings;
    }

    @Override
    public double getTotalPrice() {
        double total = basePrice;
        for (String topping : toppings) {
            switch (topping.toLowerCase()) {
                case "pineapple": total += 2.50; break;
                case "seafood": total += 3.50; break;
                default: total += 2.00; break; //ham, cheese, tomato, mushroom
            }
        }
        return total;
    }

    @Override
    public MealType getMealType() {
        boolean hasHam = toppings.contains("ham");
        boolean hasSeafood = toppings.contains("seafood");
        boolean hasCheese = toppings.contains("cheese");

        if (hasHam || hasSeafood) return MealType.MEAT;
        else if (hasCheese) return MealType.VEGETARIAN;
        else return MealType.VEGAN;
    }

    @Override
    public String toString() {
        return "Pizza with toppings: " + toppings.toString() + " | Type: " + getMealType() + " | Price: $" + getTotalPrice();
    }
}
