public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Is the number prime?");
        int num = 5099;
        Boolean result = true;

        if (num < 2){
            result = false;
        }

        for (int x=2; x<=Math.sqrt(num) ; x++ ){
            if (num % x == 0){
                result = false;
                break;
            }
        }

        System.out.println(result);

    }
}
