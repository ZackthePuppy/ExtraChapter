import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        RetrieveWord retrieveWord = new RetrieveWord();
        DisplayDesign display = new DisplayDesign();
        GuessWord guessWord = new GuessWord();
        String startAgain;

        while (true){
            String chosenWord = retrieveWord.chosenWord().toUpperCase();
            display.clearConsole();
            display.printBox("LET'S PLAY WORDLE!!!");
            
            guessWord.startGame(chosenWord, guessWord.difficulty()); //plays the game

            System.out.print("\nDo you want to start again? (Y - Yes, Anykey - No): ");
            startAgain = scanner.next();
            startAgain += scanner.nextLine();

            if (!startAgain.equalsIgnoreCase("Y")){
                System.out.println("Thank you for playing!");
                scanner.close();
                break;
            }
        }

    }
}
