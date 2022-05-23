import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        MySQLProcess mysql = new MySQLProcess(); // instantiation of class
        DisplayDesign go = new DisplayDesign(); // instantiation, this class is purely for designs in output
        Scanner sc = new Scanner(System.in); // scanner instantiation
        int choice;
        boolean mainLoop = true;

        while (mainLoop) {
            try {
                go.printBox("MIKE'S BURGER (CRUD)");
                System.out.print("[1] - View All Burgers \n[2] - Add Burger \n[3] - Sell Burger" +
                        " \n[4] - Delete Burger \n[5] - Exit \n\nChoose: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        mysql.viewAll();
                        break;
                    case 2:
                        mysql.addBurger();
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid selection! Try again.");
                        break;
                }
                go.PauseClear();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Try again.");
                sc.nextLine();
                go.PauseClear();
            }

        }
        sc.close();

    }
}
