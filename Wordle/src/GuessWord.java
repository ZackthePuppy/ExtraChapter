import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GuessWord {
    Scanner scanner = new Scanner(System.in);
    DisplayDesign display = new DisplayDesign();

    public void startGame(String chosenWord, int difficulty) throws IOException {
        ArrayList<String> hintedWords = new ArrayList<String>();
        display.clearConsole();
        String correctWord[] = new String[5];
        String guessWord[] = new String[5];
        String wordCheck;

        for (int x = 0; x < 5; x++) {
            correctWord[x] = Character.toString(chosenWord.charAt(x));
            guessWord[x] = "-";
        }

        for (int a = 0; a < difficulty; a++) {

            printHintedWords(hintedWords);

            for (int b = 0; b < 5; b++) {
                System.out.printf("%-3s", guessWord[b]);
            }

            wordCheck = validateInputword("\n[" + (a + 1) + "/" + difficulty + " TRY] Guess the word: ");

            for (int x = 0; x < 5; x++) {
                if (correctWord[x].equalsIgnoreCase(Character.toString(wordCheck.charAt(x)))) {
                    guessWord[x] = Character.toString(wordCheck.charAt(x));
                }
            }

            if (!Arrays.toString(guessWord).contains("-")) {
                System.out.print("\nCONGRATULATIONS! YOU WIN! Word forda day: ");
                for (int y = 0; y < 5; y++) {
                    System.out.print(guessWord[y].toUpperCase());
                }
                display.pauseClear();
                break;
            }

            else {
                for (int c = 0; c < 5; c++) {
                    for (int d = 0; d < 5; d++) {

                        // save to guessword[c] if the letter is in correct placing
                        if ((Character.toString(wordCheck.charAt(c)).equalsIgnoreCase(correctWord[d])) && (c == d)) {
                            guessWord[c] = correctWord[c];
                            hintedWords.add(Character.toString(wordCheck.charAt(c)));

                            // save to hintedwords if the letter is correct but not in correct position
                        }
                        if ((Character.toString(wordCheck.charAt(c)).equalsIgnoreCase(correctWord[d])) && (c != d)) {
                            hintedWords.add(Character.toString(wordCheck.charAt(c)));
                        }

                    }
                }
            }

            if (Arrays.toString(guessWord).contains("-") && (a == difficulty)) {
                System.out.println("You failed! GAME OVER! The word is: " + chosenWord);
            }

            display.pauseClear();
        }

        // scanner.close();

    }

    public int difficulty() {
        int difficulty, choice, index = 0;
        int difficultyLimit[] = { 20, 15, 10 };
        System.out.println("[1] Easy (20 Tries) \n[2] Medium (15 Tries) \n[3] Hard (10 Tries)");
        choice = validateDifficulty("Select Difficulty: ");

        while (true) {
            if ((choice == index) && (choice == 1 || choice == 2 || choice == 3)) {
                difficulty = difficultyLimit[choice - 1];
                break;
            } else {
                index++;
            }
        }
        return difficulty;
    }

    private void printHintedWords(ArrayList<String> hintedWords) {
        // stores hinted words in new arraylist, without duplicates
        ArrayList<String> noDuplicateHintedWords = new ArrayList<String>();

        for (String string : hintedWords) {
            if (!noDuplicateHintedWords.contains(string))
                noDuplicateHintedWords.add(string);
        }

        System.out.print("HINTED LETTERS: ");
        for (String print : noDuplicateHintedWords) {
            System.out.print(print + " ");
        }
        System.out.println();
    }

    private int validateDifficulty(String print) {
        int choice;
        while (true) {
            System.out.print(print);
            choice = scanner.nextInt();

            if (!(choice == 1 || choice == 2 || choice == 3)) {
                System.out.println("Invalid choice! ");
                display.pause();
            } else {
                return choice;
            }
        }
    }

    private String validateInputword(String print) {
        String letter;
        while (true) {
            System.out.print(print);
            letter = scanner.next();

            if ((letter.length() != 5) || (letter.isBlank())) {
                System.out.println("Error! Type 5-letter word only!");
                display.pause();
            } else {
                return letter;
            }
        }
    }

}