import java.io.IOException;
import java.util.Scanner;

public class InputValidation {

    public String checkAnswer(String print) {
        Scanner scanner = new Scanner(System.in);
        String choice = "";

        while (true) {
            System.out.print(print + "\nAnswer: ");
            choice = scanner.next();

            if ((choice.equalsIgnoreCase("a") ||
                    choice.equalsIgnoreCase("b") ||
                    choice.equalsIgnoreCase("c")) == true) {
                clearConsole();
                break;
            } else {
                System.out.println("INVALID answer.");
                pauseClear();
            }

        }
        return choice;
    }

    private void pauseClear() {
        System.out.print("\nPress \"ENTER\" to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        clearConsole();
    }

    private void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {
        }
    }

}
