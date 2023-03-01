import java.util.ArrayList;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Your order, please");

        String words = "4of Fo1r pe6ople g3ood th5e the2";
        StringTokenizer wordsToken = new StringTokenizer(words, " ");
        String[] orderedString = new String[wordsToken.countTokens()];
        String result = "";

        for (int x = 0; x < orderedString.length; x++) {
            orderedString[x] = wordsToken.nextToken();
        }

        for (int x = 0; x < orderedString.length; x++) {

            for (int y = 0; y < orderedString.length; y++) {

                if (orderedString[y].contains(Integer.toString(x + 1))) {
                    result += orderedString[y] + " ";
                }

            }
        }

        System.out.println(result.isBlank() ? "" : result.substring(0, result.length() - 1));

    }
}
