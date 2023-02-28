import java.lang.reflect.Method;
import java.util.Scanner;

public class TypeCalculator {

    private String[] allTypesNames = { "Normal", "Fire", "Water", "Grass", "Electric", "Ice", "Fighting", "Poison",
            "Ground", "Flying", "Psychic", "Bug", "Rock", "Ghost", "Dragon", "Dark", "Steel", "Fairy" };
    private Double[] allTypesValues = { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
            1.0, 1.0 };
    private Double[] finalValue = new Double[allTypesValues.length];
    private Double[] moveTypeValue = new Double[allTypesValues.length];
    private String superDamage = "";
    private String superDamage2 = "";
    private String weakDamage = "";
    private String weakDamage2 = "";
    private String noDamage = "";
    private String format = "%-30s %-50s\n";
    private Scanner scanner = new Scanner(System.in);
    private Method method, method2;
    private DisplayDesign design = new DisplayDesign();
    private PokemonTypeValues typeValues = new PokemonTypeValues();
    private Double[] typeValue, typeValue2;

    public void pokemonType(String type) throws Exception { // FOR OPTION #1 SINGLE TYPE POKEMON
        method = PokemonTypeValues.class
                .getDeclaredMethod(type.toLowerCase());
        typeValue = (Double[]) method.invoke(typeValues); // calls the method then return the value
        design.clearConsole();

        calculateDamage(typeValue, null, 1);
        damageEquivalent(finalValue);
        checkEffectivityType();
        printStatistics("Move type effectiveness against your Pokemon (" + type.toUpperCase() + ")",
                "And the rest are normal damage to your Pokemon!");
    }

    public void pokemonDualType(String primaryType, String secondaryType) throws Exception { // FOR OPTION #2 DUAL TYPE
                                                                                             // POKEMONS
        while (true) {
            if (primaryType.equalsIgnoreCase(secondaryType)) {
                System.out.println("2 types must be different! Try again.");
                design.pauseClear();
                pokemonDualType(validateType("Enter Pokemon's 1st Type: "), validateType("Enter Pokemon's 2nd Type: "));
            }

            method = PokemonTypeValues.class
                    .getDeclaredMethod(primaryType.toLowerCase());
            method2 = PokemonTypeValues.class
                    .getDeclaredMethod(secondaryType.toLowerCase());
            typeValue = (Double[]) method.invoke(typeValues); // calls the method then return the value
            typeValue2 = (Double[]) method2.invoke(typeValues); // calls the method then return the value
            design.clearConsole();

            calculateDamage(typeValue, typeValue2, 2);
            damageEquivalent(finalValue);
            checkEffectivityType();

            printStatistics("Move type effectiveness against your Pokemon (" + primaryType.toUpperCase()
                    + " & " + secondaryType.toUpperCase() + ")",
                    "And the rest are normal damage to your Pokemon!");

            break;
        }
    }

    public void moveType(String type) throws Exception { // FOR OPTION #3
        design.clearConsole();

        int index = 0;
        for (int x = 0; x < allTypesValues.length; x++) {
            if (type.equalsIgnoreCase(allTypesNames[x])) {
                index = x;
                break;
            }
        }

        for (int y = 0; y < allTypesNames.length; y++) {
            method = PokemonTypeValues.class
                    .getDeclaredMethod(allTypesNames[y].toLowerCase());
            Double[] typeValue = (Double[]) method.invoke(typeValues); // calls the method then return the value
            moveTypeValue[y] = typeValue[index];
        }

        calculateDamage(moveTypeValue, null, 1);
        damageEquivalent(finalValue);
        checkEffectivityType();
        printStatistics("Move type effectiveness to other types (" + type.toUpperCase() + ")",
                "And the rest of types are normal to " + type.toUpperCase() + " type!");
    }

    public String validateType(String print) {
        String input;

        while (true) {
            System.out.print(print);
            input = scanner.next();

            for (int x = 0; x < allTypesNames.length; x++) {
                if (input.equalsIgnoreCase(allTypesNames[x])) {
                    return input;
                }
            }

            System.out.println("Invalid Type. Try Again!");
            design.pauseClear();
        }
    }

    private void checkEffectivityType() {
        if (weakDamage.isBlank()) {
            weakDamage = "None  ";
        }
        if (weakDamage2.isBlank()) {
            weakDamage2 = "None  ";
        }
        if (superDamage.isBlank()) {
            superDamage = "None  ";
        }
        if (superDamage2.isBlank()) {
            superDamage2 = "None  ";
        }
        if (noDamage.isBlank()) {
            noDamage = "None  ";
        }
    }

    private void damageEquivalent(Double[] finalValue) {
        for (int x = 0; x < allTypesValues.length; x++) {
            if (finalValue[x] == 0.0) {
                noDamage += allTypesNames[x] + ", ";
            }
            if (finalValue[x] == 0.25) {
                weakDamage2 += allTypesNames[x] + ", ";
            }
            if (finalValue[x] == 0.5) {
                weakDamage += allTypesNames[x] + ", ";
            }
            if (finalValue[x] == 2.0) {
                superDamage += allTypesNames[x] + ", ";
            }
            if (finalValue[x] == 4.0) {
                superDamage2 += allTypesNames[x] + ", ";
            }
        }
    }

    private void printStatistics(String print, String print2) {
        design.printBox(print);
        System.out.printf(format, "Super Effective (x4): ",
                superDamage2.substring(0, superDamage2.length() - 2));
        System.out.printf(format, "Super Effective: ", superDamage.substring(0, superDamage.length() - 2));
        System.out.printf(format, "Not Very Effective: ", weakDamage.substring(0, weakDamage.length() - 2));
        System.out.printf(format, "Not Very Effective (1/4): ", weakDamage2.substring(0, weakDamage2.length() - 2));
        System.out.printf(format, "Immune: ", noDamage.substring(0, noDamage.length() - 2));
        System.out.println(print2);

        design.pauseClear();
    }

    private void calculateDamage(Double[] value, Double[] value2, int type) {
        if (type == 1) {
            for (int x = 0; x < allTypesValues.length; x++) {
                finalValue[x] = allTypesValues[x] * value[x];
            }
        }
        if (type == 2) {
            for (int x = 0; x < allTypesValues.length; x++) {
                finalValue[x] = (allTypesValues[x] * value[x]) * (allTypesValues[x] * value2[x]);
            }
        }
    }

}
