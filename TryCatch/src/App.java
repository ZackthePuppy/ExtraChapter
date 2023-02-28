import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // Scanner scan = new Scanner (System.in);
        // int choice;
        // TryCatch validateInt = new TryCatch();

        //     choice = validateInt.tryCatch("TEST: ");
        //     System.out.println(choice);

        
        String hatdog = "C190200";
        System.out.println(hatdog.substring(1));
        if (hatdog.substring(1).length() != 5){
            System.out.println("not equal");
        }
        else {
            System.out.println("equal");
        }

    }
}
