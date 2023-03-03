import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Take a Ten Minutes Walk");
        char[] walk = { 'n','n','n','s','n','s','n','s','n','s' };
        Boolean result = true;
        int [] count = new int [4];
        
        System.out.println(Arrays.toString(walk));

        if (walk.length != 10) {
            result = false;
        } else {
            for (int x = 0; x < 10; x++) {
                if (walk[x] == 'n'){
                    count[0] ++;
                }
                else if (walk[x] == 's'){
                    count[1] ++;
                }
                else if (walk[x] == 'e'){
                    count[2] ++;
                }
                else if (walk[x] == 'w'){
                    count[3] ++;
                }
            }

        }

        System.out.println(count[0] == count[1] && count[2] == count[3] ? "True" : "False");

    }
}
