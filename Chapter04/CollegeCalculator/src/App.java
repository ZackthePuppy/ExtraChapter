import java.text.NumberFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        NumberFormat money = NumberFormat.getCurrencyInstance();
        double cost = 0, offset, total;
        System.out.println("College Cost Calculator (Put 0 if not Applicable)");
        
        System.out.println("EXPENSES");
        System.out.print("Rent: ");
        cost += sc.nextDouble();
        System.out.print("Tuition Fee: ");
        sc.nextDouble();
        System.out.print("Books: ");
        cost += sc.nextDouble();
        System.out.print("Laboratory: ");
        cost += sc.nextDouble();
        System.out.print("Food: ");
        cost += sc.nextDouble();

        System.out.println("\nOFFSET");
        System.out.print("Scholar: ");
        offset = sc.nextDouble();

        total = cost - offset;

        System.out.println("\nMoney need for this school year " + money.format(total));
        sc.close();
    }
}
