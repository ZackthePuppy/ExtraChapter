import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Convert F to C");
        double f, c;

        System.out.print("Enter value of Fahrenheit: ");
        f = sc.nextDouble();

        c = 5/9 *(f-32);

        System.out.println("Value in Celcius: " + c);
    }
}
