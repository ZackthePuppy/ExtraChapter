import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Debugging {
    // public static void main(String[] args) throws Exception {
    //     System.out.println("Hello, Fibonacci!");
    //     Scanner scanner = new Scanner(System.in);

    //     int one = 1;
    //     int total = 0;
    //     int tempHolder = 0;
    //     int n;
    //     String result = "0, ";
    //     String position = "0, ";


    //     total += one;

    //     for (int x=0; x<n; x++){
    //         result += total + ", ";
    //         total += tempHolder;
    //         tempHolder = total - tempHolder;
    //         position += (x+1) + ", ";
    //     }
        
    //     System.out.println(result.substring(0, result.length()-2));
    //     System.out.println(position.substring(0, position.length()-2));
    // }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Fibonacci!");
        Scanner scanner = new Scanner(System.in);

        int one = 1;
        int total = 0;
        int tempHolder = 0;
        int n = 15;
        String result = "0, ";
        String position = "0, ";


        total += one;

        for (int x=0; x<n; x++){
            result = total + "";
            total += tempHolder;
            tempHolder = total - tempHolder;
            position += (x+1) + ", ";
        }
        
        System.out.println(result);
        System.out.println(position.substring(0, position.length()-2));

    }

    // public static void run() {
    //     Debugging d1 = new Debugging();
    //     List<Integer> li = List.of(5,-13,41,5413);
    //     List<String> ls = list.of ("Aa", "cad", "dada");
    //     System.out.println(Arrays.toString(d1));
    // }

    // public int [] getComputedHashCodes(List<?> objects) {
    //     int [] hashes = new int [objects.size()];

    //     int i=0;
    //     for (Object object : objects){
    //         hashes[++1] = object.hashCode();
    //     }
    // }
}
