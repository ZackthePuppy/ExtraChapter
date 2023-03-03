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


        //ANOTHER WAY FOR REVERSING WORD WITHOUT REVERSING WHOLE SENTENCES
        // String original = "This is an example!";
        // if (original.isBlank()){
        //     System.out.println(original);
        // }
        // else {
            
        //     String [] splittedWords = original.split(" ");
        //     String result = "";
            
        //     for (int x=0; x<splittedWords.length; x++){
        //         for (int y=splittedWords[x].length()-1; y>=0 ; y--){
        //             result += splittedWords[x].charAt(y);
        //         }
        //         result += " ";
        //     }
            
        //     System.out.println(result.substring(0, result.length()-1));
        // }





    }
}
