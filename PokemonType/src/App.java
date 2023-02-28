import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        DisplayDesign design = new DisplayDesign();
        PokemonTypeValues pokemonType = new PokemonTypeValues();
        Scanner scanner = new Scanner(System.in);
        String input;
        Boolean mainLoop = true;

        while (mainLoop) {
            TypeCalculator typeCalculate = new TypeCalculator();
            design.printBox("WELCOME TO POKEMON TYPE CHART!");
            System.out.print("[1] Single Pokemon Type \n[2] Dual Pokemon Type " +
                    "\n[3] Move Type \n[4] List of All Types \n[5] Exit \n\nChoose: ");
            input = scanner.next();
            input += scanner.nextLine();

            switch (input) {
                case "1":
                    typeCalculate.pokemonType(typeCalculate.validateType("Enter Pokemon Type: "));
                    break;

                case "2":
                    typeCalculate.pokemonDualType(typeCalculate.validateType("Enter Pokemon's 1st Type: "),
                            typeCalculate.validateType("Enter Pokemon's 2nd Type: "));
                    break;
                case "3":
                    typeCalculate.moveType(typeCalculate.validateType("Enter Move Type: "));
                    break;

                case "4":
                    pokemonType.showAllTypes();
                    break;

                case "5":
                    System.out.println("Thank you for using my program!");
                    mainLoop = false;
                    scanner.close();
                    break;

                default:
                    System.out.println("Invalid input. Try again.");
                    design.pauseClear();
                    break;
            }
        }

    }
}
