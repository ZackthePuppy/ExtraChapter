import java.text.NumberFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner (System.in);
        NumberFormat percent = NumberFormat.getPercentInstance();
        System.out.println("Grade Average");
        int grades = 0;
        double average;

        System.out.print("Enter 1st Grade: ");
        grades += sc.nextInt();
        System.out.print("Enter 2nd Grade: ");
        grades += sc.nextInt();
        System.out.print("Enter 3rd Grade: ");
        grades += sc.nextInt();
        System.out.print("Enter 4th Grade: ");
        grades += sc.nextInt();
        System.out.print("Enter 5th Grade: ");
        grades += sc.nextInt();

        average = (double)grades/5;

        System.out.println("\nThe Average is " + percent.format(average/100));

        sc.close();
    }
}
