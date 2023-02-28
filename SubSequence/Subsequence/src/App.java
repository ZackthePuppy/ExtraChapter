import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Subsequence");
        Scanner scanner = new Scanner(System.in);
        int length;
        int count=1;
        int[] arr;

        System.out.print("How many numbers? ");
        length = scanner.nextInt();

        arr = new int[length];
        for (int x = 0; x < length; x++) {
            System.out.print("Enter number " + (x + 1) + ": ");
            arr[x] = scanner.nextInt();
        }

        System.out.println("Is increasing? " + increaseChecker(arr, length));
        System.out.println("Is decreasing? " + decreaseChecker(arr, length));

        if ((increaseChecker(arr, length) == true) || (decreaseChecker(arr, length) == true)) {
            
            System.out.println("Return 0");

        }
   
        else {
            System.out.println("Return 3");
        }

    }

    public static Boolean increaseChecker(int[] arr, int length) {
        Boolean valid = true;
        for (int x = 1; x < length; x++) {
            if (arr[x - 1] > arr[x]) {
                valid = false;
                break;
            }
        }
        return valid;
    }

    public static Boolean decreaseChecker(int[] arr, int length) {
        Boolean valid = true;
        for (int x = 1; x < length; x++) {
            if (arr[x - 1] < arr[x]) {
                valid = false;
                break;
            }
        }
        return valid;
    }

}
