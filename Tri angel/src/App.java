import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Scanner sc = new Scanner (System.in);
        int count;

        System.out.print("Number of triangle: ");
        count = sc.nextInt();

        for (int x=0; x<=count/2; x++){
            // int space = 10;

            
            for (int z=count; z>=x; z--){
                System.out.print(" ");
            }

            for (int y=1; y<=x; y++){
                System.out.print(y);
            }

            for (int y=1; y<=x; y++){
                System.out.print(y);
            }


            // System.out.print("     ");
            // for (int z=count; z>=x; z--){
            //     System.out.printf("%-" + 10 +"s", "*");

            // }


            System.out.println();
        }
    }
}
