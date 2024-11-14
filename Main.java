import javax.swing.*;
import java.awt.*;

public class Main {
    private JFrame frame;           // JFrame that will serve as the main window for the application.
    private CardLayout crdLayout;   // CardLayout is used to manage multiple panels that are displayed one at a time.
    private JPanel mainContainer;  // JPanel that holds all the frames (panels) managed by the CardLayout.www
    private IntroFrame introFrame; // Instance of the IntroFrame class, which contains the introductory panel.
    private PlayFrame playFrame;   // Instance of the PlayFrame class, which contains the main gameplay panel.
    private AskUserName askUserName; // Instance of the AskUserName class, which contains the panel where the user enters their name.
    private WelcomeUser welcomeUser; // Instance of the WelcomeUser class, which displays a personalized welcome message.

    // Constructor that sets up the main frame and initializes all components
    public Main() {
        frame = new JFrame("Who Wants To Be A Millionaire");  // Initializes the frame with a title.
        frame.setSize(800, 800);   // Sets the size of the frame (800x800 pixels).
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Ensures the application exits when the window is closed.
        frame.setLocationRelativeTo(null);  // Centers the frame on the screen.
        frame.setResizable(false);  // Prevents the window from being resized.

        crdLayout = new CardLayout();  // Initializes the CardLayout for the main container.
        mainContainer = new JPanel(crdLayout);  // Sets the main container panel with CardLayout.

        // Initializes each frame (panel) with the current Main class instance so they can interact with it.
        introFrame = new IntroFrame(this);  
        playFrame = new PlayFrame(this);   
        askUserName = new AskUserName(this);  
        welcomeUser = new WelcomeUser(this, askUserName); // Passes the AskUserName instance to WelcomeUser to share the same userName.

        // Adds each panel to the main container, associating them with a unique name for CardLayout.
        mainContainer.add(introFrame.createIntroPanel(), "IntroFrame");  
        mainContainer.add(playFrame.createPlayPanel(), "PlayFrame");  
        mainContainer.add(askUserName.createUserNameUI(), "AskUserName");  
        mainContainer.add(welcomeUser.createWelcomeUserUI(), "WelcomeUser");  

        frame.add(mainContainer);  // Adds the main container (which holds all the panels) to the frame.
        frame.setVisible(true);     // Makes the frame visible to the user.
    }

    // Method to switch between panels using CardLayout.
    // It checks which panel name is passed and switches to that panel.
    public void showPanel(String panelName) {
        if (panelName.equals("WelcomeUser")) {
            // If the "WelcomeUser" panel is to be displayed, it creates it again and adds it to the container.egfjtr
            mainContainer.add(welcomeUser.createWelcomeUserUI(), "WelcomeUser");
        }
        crdLayout.show(mainContainer, panelName);  // Displays the requested panel by name.
    }

    // Main method that starts the application by creating a new instance of Main.
    public static void main(String[] args) {
        new Main();  // Initializes the Main class and runs the application.
    }
}
