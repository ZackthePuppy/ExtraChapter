import java.util.ArrayList;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Your order, please");

        String words = "is2 Thi1s T4est 3a";
        StringTokenizer wordsToken = new StringTokenizer(words, " ");
        String [] orderedString = new String [wordsToken.countTokens()];
        String temp;

        for (int x=0; x<orderedString.length; x++) {
            orderedString[x] = wordsToken.nextToken();
        }

        for (int x = 0; x < orderedString.length; x++) {

            for (int y = 0; y < orderedString.length; y++) {

                if (orderedString[y].contains(Integer.toString(x+1))) {
                    temp = orderedString[y];
                    orderedString[y] = orderedString[x+1];
                    orderedString[x+1] = temp;
                }

            }
        }

        for (int x=0; x<orderedString.length; x++) {
            System.out.println(orderedString[x]);
        }

    }
}
