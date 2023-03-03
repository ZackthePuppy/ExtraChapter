public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Two to one");

        String s1 = "xyaabbbccccdefww";
        String s2 = "xxxxyyyyabklmopq";
        String s3 = s1.concat(s2);
        String result = "";

        for (char y = 'a'; y <= 'z'; y++) {

            for (int x = 0; x < s3.length(); x++) {
                if (y==s3.charAt(x)){
                    result += y;
                    break;
                }

            }

        }

        System.out.println(result);

    }
}
