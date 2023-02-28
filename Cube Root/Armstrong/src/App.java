import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int firstNumber, secondNumber = 0;

        System.out.print("Enter numbers: ");
        int input = scanner.nextInt();
        firstNumber = input;

        String numberString = String.valueOf(input);
        char [] digits = numberString.toCharArray();

        for (int x=0; x<digits.length; x++){
            secondNumber += Math.pow(Integer.parseInt(Character.toString(digits[x])), digits.length);
        }

        System.out.println(firstNumber == secondNumber ? "Armstrong shit" : "Not Armstrong");


    }


}
