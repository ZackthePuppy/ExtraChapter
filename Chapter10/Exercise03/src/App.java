import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("RANDOM NUMBER STATISTICS");
        int randomNumberLimit = 500, randomLimit = 10, randomNumber, totalCheck = 0;
        Random random = new Random();
        int numberOccurence [] = new int [10] ;

        for (int x = 0; x < randomNumberLimit; x++){
            randomNumber = random.nextInt(10);
            for (int y = 0; y < randomLimit; y++){
                if (randomNumber == y){
                    numberOccurence[y] ++ ;
                }
            }
        }

        System.out.println("NUMBER\tOCCURENCES");
        for (int z = 0; z < randomLimit; z++){
            System.out.println(z + "\t" + numberOccurence[z]);
        }

        for (int a = 0; a < randomLimit; a++){
            totalCheck += numberOccurence[a];
        }
        System.out.println("Total: " + totalCheck);

    }
}
