import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Process pc = new Process();
        String word;
        while (true){
            System.out.print("Enter a word (Enter to exit): ");
            word = sc.nextLine();

            if (word.isEmpty()){
                break;
            }
            else {
                pc.setWord(word);
                System.out.println(pc.getWord());
            }
        }
        sc.close();
    }
}
