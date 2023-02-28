import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int userNumber, averageDivider = 0, total = 0;
        double average;
        int[] smallBig = new int[2];
        int[] histogram = new int[10];
        int[] frequentNumberArray;
        ArrayList<Integer> frequentNumber = new ArrayList<Integer>();

        System.out.println("NUMBER ANALYSIS");

        while (true) {
            System.out.print("Enter a number between 1-50 (0 to quit): ");
            userNumber = Integer.parseInt(input.readLine());

            if (userNumber < 0) {
                System.out.print("Invalid  range!");
                input.readLine();
            } else if (userNumber > 50) {
                System.out.print("Invalid range!");
                input.readLine();
            } else if (userNumber == 0) {
                average = total / averageDivider;
                break;
            } else {
                if (averageDivider == 0) {
                    smallBig[0] = userNumber;
                    smallBig[1] = userNumber;
                }

                if (smallBig[0] > userNumber) {
                    smallBig[0] = userNumber;
                }

                if (smallBig[1] < userNumber) {
                    smallBig[1] = userNumber;
                }

                frequentNumber.add(userNumber);
                averageDivider++;
                total += userNumber;
            }
        }
        frequentNumberArray = new int[frequentNumber.size()];

        for (int x = 0; x < frequentNumberArray.length; x++) {
            frequentNumberArray[x] = frequentNumber.get(x);
        }

        System.out.println("\nAverage Number: " + average);
        System.out.println("Maximum Number: " + smallBig[1]);
        System.out.println("Range: " + smallBig[0] + " - " + smallBig[1]);
        System.out.println("Median: " + mostFrequent(frequentNumberArray, frequentNumberArray.length));

    }

    public static int mostFrequent(int[] arr, int arrLength) {
        int maxcount = 0;
        int maxFrequencyElement = 0;

        for (int i = 0; i < arrLength; i++) {
            int count = 0;

            for (int j = 0; j < arrLength; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > maxcount) {
                maxcount = count;
                maxFrequencyElement = arr[i];
            }
        }

        return maxFrequencyElement;
    }
}
