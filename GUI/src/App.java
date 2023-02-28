import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.security.auth.Subject;
import javax.swing.*;

public class App {
    
    public static void main(String[] args) throws Exception {
        String s = "This is a testingg";
        ArrayList<String> stringArraylist = new ArrayList<>();
        StringTokenizer token = new StringTokenizer(s, " ");
        char tempReverse [];
        String returnedString = "";
        while (token.hasMoreTokens()) {
          stringArraylist.add(token.nextElement().toString());
        }

        for (int x=0; x<stringArraylist.size(); x++){

          if (stringArraylist.get(x).length() >= 5){
            tempReverse = new char [stringArraylist.get(x).length()];
            int index = stringArraylist.get(x).length();
            String reversedString = "";

            for (int y=0; y<stringArraylist.get(x).length(); y++){
              tempReverse[index-1] = stringArraylist.get(x).charAt(y);
              index --;
            }

            for (int z=0; z<stringArraylist.get(x).length(); z++){
              reversedString += tempReverse[z] + " ";
            }

            stringArraylist.set(x, reversedString);

          }

        }

        for (int a=0; a<stringArraylist.size(); a++){
          returnedString += stringArraylist.get(a) + " ";
        }

        System.out.println(returnedString);

    }
}
