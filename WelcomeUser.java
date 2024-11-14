import java.awt.*;
import javax.swing.*;

public class WelcomeUser {
    private Main mainClass;           // This stores a reference to the Main class instance, which is passed in when creating WelcomeUser.
    private AskUserName askUserName;  // This stores a reference to the existing AskUserName class instance, allowing access to the user's name.

    // Constructor that takes Main and AskUserName class instances as parameters
    public WelcomeUser(Main mainClass, AskUserName askUserName) {
        this.mainClass = mainClass;        // Initializes the mainClass variable with the passed Main class instance.
        this.askUserName = askUserName;    // Initializes the askUserName variable with the passed AskUserName class instance, sharing the same instance across classes.
    }

    // Method to create the UI components for the WelcomeUser panel
    public JPanel createWelcomeUserUI() {
        // Creates a JPanel with BorderLayout for organizing components within the panel
        JPanel welcomeUserPanel = new JPanel(new BorderLayout());  

        // Retrieves the userName from the AskUserName instance using the getUserName() method
        String userName = askUserName.getUserName();  

        // Declares the JLabel that will display the welcome message
        JLabel welcomeUserLabel;  

        // Checks if the userName is not null or empty and constructs a personalized message.
        if (userName != null && !userName.isEmpty()) {  
            // If a userName is provided, display a personalized message
            welcomeUserLabel = new JLabel("Welcome to Who Wants To Be A Millionaire, " + userName + "!");
        } 
        else {
            // If no userName is provided, display a default message ("Guest Player")
            welcomeUserLabel = new JLabel("Welcome to Who Wants To Be A Millionaire, Guest Player!");
        }

        // Aligns the label text horizontally to the center
        welcomeUserLabel.setHorizontalAlignment(JLabel.CENTER);  

        // Adds top padding to the label so it doesn't stick to the top edge of the panel
        welcomeUserLabel.setBorder(BorderFactory.createEmptyBorder(70, 0, 0, 0));  

        // Sets the font for the welcome message to be bold and sized appropriately
        welcomeUserLabel.setFont(new Font(Font.SERIF, Font.BOLD, 20));  

        // Adds the label to the panel using the NORTH position in BorderLayout
        welcomeUserPanel.add(welcomeUserLabel, BorderLayout.NORTH);  

        // Returns the constructed panel so it can be displayed in the UI
        return welcomeUserPanel;  
    }
}
                                                                                           