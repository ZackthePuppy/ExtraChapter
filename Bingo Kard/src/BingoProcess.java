public class BingoProcess {
    
    public void generateBingoCard() {
        int[][] bingoNumber = new int[5][5];
        String[][] bingoString = new String[5][5];
        String[] titleBingo = { "B", "I", "N", "G", "O" };

        int randomNumber;
        // (int)(Math.random()*(16-1+1)+1);

        for (int x = 0; x < 5; x++) {
            randomNumber = generateRandomNumber(x);

            for (int y = 0; y < 5; y++) {
                bingoNumber[x][y] = randomNumber;
                bingoString[x][y] = String.format("%7s", bingoNumber[x][y]);
                for (int z = 0; z < 5; z++) {
                    while (bingoNumber[x][z] == randomNumber) {
                        randomNumber = generateRandomNumber(x);
                        z = 0;
                    }
                }
            }

        }

        bingoString[2][2] = String.format("%7s", "FREE");

        for (int x = 0; x < 5; x++) {
            System.out.print(String.format("| %7s", titleBingo[x]));
        }
        System.out.println();
        for (int a = 0; a < 5; a++) {

            for (int b = 0; b < 5; b++) {
                System.out.print("| " + bingoString[b][a]);
            }
            System.out.println();

        }
    }

    public int generateRandomNumber(int index) {
        int[] range = { 1, 16, 31, 46, 61, 75 };
        return (int) (Math.random() * (range[index + 1] - range[index])) + range[index];
    }

}
