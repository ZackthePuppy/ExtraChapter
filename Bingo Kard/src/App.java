import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        BingoProcess bingo = new BingoProcess ();
        Scanner scan = new Scanner (System.in);
        String input;
        System.out.println("BINGO CARD");

        bingo.generateBingoCard();
        System.out.println("Press ENTER to start!");
        input = scan.nextLine();
    }

}
