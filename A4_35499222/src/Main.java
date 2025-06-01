import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderController manager = new OrderController(); //to initialise manager
        int choice;

        do {
            System.out.println("\nWelcome to the takeaway system");
            System.out.println("1. Enter a new order");
            System.out.println("2. Deliver next order");
            System.out.println("3. View all orders");
            System.out.println("4. Exit");
            System.out.print("Enter your choice:\n");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // clear newline




            switch (choice) {
                case 1:
                    List<FoodItem> foodItems = new ArrayList<>();

                    //asks how many items customer wants to add
                    System.out.print("How much food in this order? (We can only take up to 10 items in an order)\n");
                    int itemCount = Math.min(scanner.nextInt(), 10);
                    scanner.nextLine(); //clear newline func
                    boolean exitEarly = false;

                    for (int i = 0; i < itemCount; i++) {

                        while (true) {

                            //then it moves into a for loop and starts to ask for either pizza or pasta
                            System.out.print("Is this item (#" + (i + 1) + ") a pizza or pasta? (type 'exit' to stop ordering):\n");
                            String type = scanner.nextLine().trim().toLowerCase(); //case sensitivity

                            if (type.equals("exit")) {
                                exitEarly = true;
                                break;
                            }

                            //if else case 1 is for pizza, then goes into a for loop asking for how many toppings
                            if (type.equals("pizza")) {
                                List<String> toppings = new ArrayList<>();
                                System.out.print("How many toppings? (max 10): ");
                                int toppingCount = Math.min(scanner.nextInt(), 10);
                                scanner.nextLine(); //clear newline function again

                                for (int j = 0; j < toppingCount; j++) {
                                    System.out.print("Enter topping no. " + (j + 1) + ": (ham, cheese, pineapple, mushroom): ");
                                    String topping = scanner.nextLine().toLowerCase();
                                    toppings.add(topping);
                                }

                                Pizza pizza = new Pizza(toppings);
                                foodItems.add(pizza);
                                break;
                            }

                            //same case for the one above but this one is pasta
                            else if (type.equals("pasta")) {
                                System.out.print("Enter pasta topping (tomato, bolognese, marinara, primavera): ");
                                String topping = scanner.nextLine().toLowerCase();
                                Pasta pasta = new Pasta(topping);
                                foodItems.add(pasta);
                                break;
                            }

                            //final case if user enters invalid input
                            else {
                                System.out.println("Invalid option. Please enter either 'pizza' or 'pasta'.");
                            }
                        }

                        if (exitEarly) {
                            System.out.println("Stopping order...");
                            break;
                        }
                    }

                    //customer details
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();

                    Order order = new Order(name, phone, address, foodItems);
                    manager.addOrder(order);
                    break;

                case 2:
                    manager.deliverNextOrder();
                    break;

                case 3:
                    manager.viewAllOrders();
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
