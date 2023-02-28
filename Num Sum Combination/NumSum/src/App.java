import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("NUM SUM COMBINATION");
        ArrayList<Integer> numbers = new ArrayList<>();
        String combination = "";

        for (int a=1; a<=10; a++){
            numbers.add(a);
        }

        for (int b=0; b<10; b++){

            for (int c=b; c<10; c++){
                if ((numbers.get(b) + numbers.get(c) == 15) ){
                    combination += "'" + numbers.get(b) + "' and '" + numbers.get(c) + "\n";
                
                }
            }

        }

        System.out.println("Combinations of number 15: \n" + combination);


    }
}
