import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        double time, height;

        System.out.println("Height of an Object");
        System.out.print("Enter a time less than 4.5 seconds: ");
        time = sc.nextDouble();
        height = 100-4.9 * (time * 2);

        System.out.print("The height of the object is: " + height + " meters");
        sc.close();
    }
}

