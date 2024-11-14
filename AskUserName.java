import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AskUserName {
    private Main mainClass;  // Declaring a reference to the Main class to interact with the rest of the application
    private String userName;  // Declaring a variable to hold the user's name entered in the JTextField

    // Constructor accepts the mainClass object para maka-access tanan in each classes
    public AskUserName(Main mainClass) {
        this.mainClass = mainClass;  // Saving the reference of Main class for later use
    }

    // This method creates the user interface for asking the user their name
    public JPanel createUserNameUI() {
        JPanel userPanel = new JPanel(new GridBagLayout());  // Creating a panel with GridBagLayout for flexible positioning of components
        userPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));  // Setting an empty border around the panel to avoid tight spacing

        // Creating an object to handle the grid layout constraints
        GridBagConstraints gbc = new GridBagConstraints();

        // Creating a JLabel to prompt the user to enter their name
        JLabel labelUser = new JLabel("Please enter your name: ");
        labelUser.setFont(new Font(Font.SERIF, Font.PLAIN, 20));  // Setting font for the label
        labelUser.setHorizontalAlignment(JLabel.CENTER);  // Centering the text of the label horizontally
        labelUser.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));  // Adding padding below the label to avoid tight spacing

        // Creating a JTextField for the user to input their name
        JTextField userTextField = new JTextField(20);  // Setting the width of the text field
        userTextField.setFont(new Font(Font.SERIF, Font.PLAIN, 25));  // Setting the font of the text field
        userTextField.setHorizontalAlignment(JTextField.CENTER);  // Centering the text in the text field

        // Creating a JPanel to wrap the JTextField, which will allow adding padding
        JPanel textFieldPanel = new JPanel(new BorderLayout());  // Creating a new panel with BorderLayout for better management
        textFieldPanel.add(userTextField, BorderLayout.CENTER);  // Adding the JTextField to the center of the panel
        textFieldPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));  // Adding bottom padding to text field panel

        // Creating a button labeled "Enter" for the user to submit their name
        JButton enterButton = new JButton("Enter");
        // Adding an ActionListener to the button to capture the user’s click event
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // When the button is clicked, capture the user input and store it in the userName variable
                userName = userTextField.getText().trim();  // Retrieve the text, removing leading/trailing whitespace
                mainClass.showPanel("WelcomeUser");  // Call the showPanel method from the Main class to navigate to the next panel (WelcomeUser)
            }
        });

        // Setting the constraints for the JLabel (positioning it in the grid)
        gbc.gridx = 0;  // Set the component to be at the first column
        gbc.gridy = 0;  // Set the component to be at the first row
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Make the label stretch horizontally across the panel
        userPanel.add(labelUser, gbc);  // Adding the label to the userPanel at the specified position

        // Setting the constraints for the text field panel (positioning it below the label)
        gbc.gridy = 1;  // Set the row index to 1, positioning it below the label
        gbc.fill = GridBagConstraints.NONE;  // The text field should not stretch horizontally, it will be placed at its preferred size
        gbc.anchor = GridBagConstraints.CENTER;  // Centering the text field in the panel
        userPanel.add(textFieldPanel, gbc);  // Adding the text field panel to the userPanel

        // Setting the constraints for the Enter button (positioning it below the text field)
        gbc.gridy = 2;  // Set the row index to 2, positioning it below the text field
        userPanel.add(enterButton, gbc);  // Adding the Enter button to the userPanel at the specified position

        return userPanel;  // Returning the constructed panel with all components
    }

    // Getter method to retrieve the user's name entered in the JTextField
    public String getUserName() {
        return userName;  // Return the stored userName
    }
}
