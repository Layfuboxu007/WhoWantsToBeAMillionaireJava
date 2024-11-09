import javax.swing.*;
import java.awt.*;

public class Main {
    private JFrame frame;
    private CardLayout crdLayout;
    private JPanel mainContainer;

    public Main() {
        frame = new JFrame("Who Wants To Be A Millionaire");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        crdLayout = new CardLayout();  // Initialize CardLayout.
        mainContainer = new JPanel(crdLayout);  // Set mainContainer with CardLayout.

        IntroFrame intro = new IntroFrame(this);
        PlayFrame play = new PlayFrame(this);
        AskUserName user = new AskUserName(this);

        mainContainer.add(intro.createIntroPanel(), "IntroFrame");
        mainContainer.add(play.createPlayPanel(), "PlayFrame");
        mainContainer.add(user.createUserNameUI(), "AskUserName");
        
        frame.add(mainContainer);
        frame.setVisible(true);
    }

    // Method to switch between panels
    public void showPanel(String panelName) {
        crdLayout.show(mainContainer, panelName);
    }
    public static void main(String[] args) {
        new Main();
    }
}
