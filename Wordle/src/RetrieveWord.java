import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class RetrieveWord {

    public String chosenWord() throws IOException {
        Random random = new Random();
        String chosenWord = "";

        try {
            File textFile = new File("src/word.txt");
            FileReader in = new FileReader(textFile);
            BufferedReader readTextFile = new BufferedReader(in);
            // saves the word in token. Also, divides the words by using the pattern comma
            StringTokenizer stringToken = new StringTokenizer(readTextFile.readLine(), ", ");
            ArrayList<String> word = new ArrayList<String>();

            while (stringToken.hasMoreElements()) {
                word.add(stringToken.nextElement().toString()); // saves to arraylist, from token
            }

            chosenWord = word.get(random.nextInt(word.size()));
            readTextFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error! " + e.getMessage());
            enterToContinue();
        } catch (IOException e) {
            System.out.println("Error! " + e.getMessage());
            enterToContinue();
        }

        return chosenWord;
    }

    public void enterToContinue() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nPress ENTER to Continue...");
        br.read();
    }

}
