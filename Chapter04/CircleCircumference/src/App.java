import java.text.NumberFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        NumberFormat decimal = NumberFormat.getNumberInstance();
        double pi = 3.14;
        int r;
        System.out.println("Circumference");
        System.out.print("Enter Radius: ");
        r = sc.nextInt();

        pi = (double)2 * pi * r;

        System.out.print("The Circumference is " + decimal.format(pi));
        sc.close();
    }
}
