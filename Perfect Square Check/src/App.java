public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("You're a square!");
        int n = 149880068;
        double squareRoot = Math.sqrt(n);

        System.out.println( squareRoot == Math.floor(squareRoot) ? "Perfect Square" : "Not Perfect" );
        
    }
}
