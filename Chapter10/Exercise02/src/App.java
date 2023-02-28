public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("GENERATED NUMBERS");
        String divider;
        int generatedNumber;

        for (int x = 0; x < 102; x++) {

            generatedNumber = x; // adds the current index to generatedNumber
            divider = String.valueOf(x); // converts the int to string, so we can dissect it later
            System.out.print(x + "\t"); // prints the index

            for (int y = 0; y < Integer.toString(x).length(); y++) {
                generatedNumber += Character.getNumericValue(divider.charAt(y)); // converts the dissected string (char
                                                                                 // to int) int order to add it in
                                                                                 // generatedNumber
            }

            System.out.println(generatedNumber); //prints the generated number

        }
    }
}
