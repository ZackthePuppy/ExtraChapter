import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Random random = new Random ();
        System.out.println("EXERCISE 01 - EVEN AND ODDS\n");
        int randomLimit = 100, randomNumber;
        String even = "", odd = "";

        for (int x = 0; x < 25; x++){
            randomNumber = random.nextInt(randomLimit);

            if (randomNumber % 2 == 0){ //check if random number is even
                even += randomNumber + " | ";
            }

            else {
                odd += randomNumber + " | ";
            }
        }

        System.out.println("ODD: \n" + odd);
        System.out.println("\nEVEN: \n" + even);

    }

}
