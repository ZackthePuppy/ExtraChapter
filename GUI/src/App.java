import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class App {
    

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("SAMPLE GUI");
        JLabel label = new JLabel("HELLO WORLD!");
        JButton button = new JButton("Click me!!!");
        JButton button2 = new JButton("another button");

        frame.setVisible(true); //shows the window/jframe
        frame.setSize(400, 500); //sets the window size
        frame.add(label);
        frame.add(button); //adds the button into the frame
        frame.add(button2);

        frame.setLayout(null); //so the components wont messed up

        //sets the placing and the sizes of buttons, labels, etc.
        label.setBounds(200, 0, 400, 50);
        button.setBounds(0, 90, 100, 100);
        button2.setBounds(50, 10, 50, 50);

    }
}
