import java.util.ArrayList;
import java.util.Collections;

public class Process {
    private String[][] showAnswers = new String[2][8];
    ArrayList<Integer> numbers = new ArrayList<>();
    int aCount = 0;
    int bCount = 0;
    int cCount = 0;

    public void startQuestion() {
        InputValidation validate = new InputValidation();
        int size = 8;

        for (int x = 0; x < size; x++) {
            numbers.add(x);
        }

        Collections.shuffle(numbers); // randomize the contents of arraylist numbers

        for (int y = 0; y < size; y++) {
            int questionNumber = numbers.get(y);
            String questionnaire = "";
            questionnaire += (getQuestions()[questionNumber][0]) + "\n";

            for (int z = 1; z <= 3; z++) {
                questionnaire += (getQuestions()[questionNumber][z]) + "\n";
            }

            setAnswer(questionNumber, validate.checkAnswer(questionnaire));

        }
        showResults();
        aCount = bCount = cCount = 0;

    }

    private String[][] getQuestions() {
        String[][] questions = new String[8][4];

        // QUESTION #1
        questions[0][0] = "You went to a party last night and when you" +
                "arrived to school the next day, everybody is" +
                "talking about something you didn’t do. What" +
                "will you do?";
        questions[0][1] = "A. Avoid eveything and go with your friends.";
        questions[0][2] = "B. Go and talk with the person that started the rumors.";
        questions[0][3] = "C. Go and talk with the teacher.";

        // QUESTION #2
        questions[1][0] = "What quality do you excel the most?";
        questions[1][1] = "A. Empathy";
        questions[1][2] = "B. Curiosity";
        questions[1][3] = "C. Perseverance";

        // QUESTION #3
        questions[2][0] = "You are walking down the street when you see" +
                "an old lady trying to cross, what will you do?";
        questions[2][1] = "A. Go and help her.";
        questions[2][2] = "B. Go for a policeman and ask him to help.";
        questions[2][3] = "C. Keep walking ahead.";

        // QUESTION #4
        questions[3][0] = "You had a very difficult day at school, you will" +
                "maintain a ____ attitude";
        questions[3][1] = "A. Depends on the situation.";
        questions[3][2] = "B. Positive";
        questions[3][3] = "C. Negative";

        // QUESTION #5
        questions[4][0] = "You are at a party and a friend of yours comes" +
                "over and offers you a drink, what do you do?";
        questions[4][1] = "A. Say no thanks.";
        questions[4][2] = "B. Drink it until it is finished.";
        questions[4][3] = "C. Ignore him and get angry at him.";

        // QUESTION #6
        questions[5][0] = "You just started in a new school, you will...";
        questions[5][1] = "A. Go and talk with the person next to you.";
        questions[5][2] = "B. Wait until someone comes over you.";
        questions[5][3] = "C. Not talk to anyone.";

        // QUESTION #7
        questions[6][0] = "In a typical Friday, you would like to..";
        questions[6][1] = "A. Go out with your close friends to eat.";
        questions[6][2] = "B. Go to a social club and meet more people.";
        questions[6][3] = "C. Invite one of your friends to your house.";

        // QUESTION #8
        questions[7][0] = "Your relationship with your parents is..";
        questions[7][1] = "A. I like both equally.";
        questions[7][2] = "B. I like my Dad the most.";
        questions[7][3] = "C. I like my Mom the most.";

        return questions;
    }

    private void setAnswer(int index, String choice) {
        showAnswers[0][index] = (index + 1) + "";
        showAnswers[1][index] = choice;

        switch (choice) {
            case "a":
            case "A":
                aCount++;
                break;
            case "b":
            case "B":
                bCount++;
                break;
            case "c":
            case "C":
                cCount++;
                break;
        }
    }

    private void showResults() {
        System.out.format("%-12s %-6s\n", "QUESTION #", "ANSWER");

        for (int x = 0; x < numbers.size(); x++) {
            System.out.format("%-12s %-6s\n", showAnswers[0][numbers.get(x)], showAnswers[1][numbers.get(x)]);
        }

        System.out.println("\nCount (a): " + aCount +
                "\nCount (b): " + bCount +
                "\nCount (c): " + cCount +
                "\nTotal Answers: " + (aCount + bCount + cCount));

        System.out.print("\nResult: ");
        if ((aCount > bCount) && (aCount > cCount) || (aCount == cCount) && bCount < 4) {
            printResult("b");
        } else if ((bCount > aCount) && (bCount > cCount) || (aCount == bCount) && cCount < 4
                || (bCount == cCount) && aCount < 4) {
            printResult("c");
        } else if ((cCount > aCount) && (cCount > bCount)) {
            printResult("a");
        }

    }

    private void printResult(String result) {
        switch (result) {
            case "a":
                System.out.println("Self-Management You manage yourself well;" +
                        "You take responsibility for your own behavior " +
                        "and well-being.");
                break;

            case "b":
                System.out.println("Empathy You are emphatic. You see yourself " +
                        "in someone else's situation before doing " +
                        "decisions. You tend to listen to other's voices.");
                break;

            case "c":
                System.out.println("Self-Awareness You are conscious of your " +
                        "own character, feelings, motives, and desires. " +
                        "The process can be painful but it leads to greater self-awareness.");
                break;
        }
    }

}
