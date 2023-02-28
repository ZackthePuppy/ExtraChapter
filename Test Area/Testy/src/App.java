import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        String input;
        Scanner scanner = new Scanner (System.in);

        System.out.print("Enter a word: ");
        input = scanner.nextLine();

        System.out.println( Character.isUpperCase(input.charAt(0)) ? input.toUpperCase() : input.toLowerCase() );

        scanner.close();
        
    }





}
