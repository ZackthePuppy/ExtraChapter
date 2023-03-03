import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Two Word Name");
        String name = "Sam Harris";
        String [] splittedName = name.split(" ");
        String result = splittedName[0].charAt(0) + "." + splittedName[1].charAt(0);

        System.out.println(result.toUpperCase());
    }
}
