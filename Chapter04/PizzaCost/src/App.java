import java.text.NumberFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        NumberFormat money = NumberFormat.getCurrencyInstance();
        double labor = 0.75, rent = 1.00, material = 0.05, diameter, cost;
        System.out.println("Pizza Cost");
        System.out.print("Enter the diameter of the pizza in inches: ");
        diameter = sc.nextDouble();
        cost = (labor + rent) + (material * diameter * diameter);

        System.out.println("The cost of making the pizza is: " + money.format(cost));
        sc.close();
    }
}
