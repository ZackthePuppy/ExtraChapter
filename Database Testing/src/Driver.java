import java.util.Scanner;
public class Driver {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Burger burger = new Burger();
        DisplayDesign go = new DisplayDesign(); // instantiation of class, this is only for designs and clearing
                                                // consoles
        int choice;
        boolean mainLoop = true;

        while (mainLoop) {

            try  {
                go.printBox("MEOW'S BURGER");

                System.out.print("[1] - View Burgers \n[2] - Add a Burger to Inventory \n[3] - Add Burger Quantity" +
                        "\n[4] - Sell a Burger \n[5] - Update Burger Name \n[6] - Delete a Burger \n[7] - Exit \n\nChoose: ");
                choice = sc.nextInt(); // prompts the user to choose from menu

                if (choice > 0 && choice < 7){ //executes if user follows the instruction/types correctly
                    go.clearConsole();
                    burger.chosen(choice);
                }

                else if (choice == 7){ //terminates the code if user typed 7
                    System.out.println("Thank you!");
                    mainLoop = false;
                    sc.close();
                }

                else { 
                    System.out.println("Invalid choice!");
                }

                go.PauseClear();

            } catch (Exception e) {
                System.out.print("Invalid input! Try again.");
                sc.nextLine();
                go.PauseClear();
            }

        }

    }
}
