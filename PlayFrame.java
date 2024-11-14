import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayFrame {
    private Main mainClass;  // Reference to the Main class, allowing interaction with the rest of the application.

    // Constructor that initializes the PlayFrame with a reference to the Main class.
    public PlayFrame(Main mainClass) {
        this.mainClass = mainClass;
    }

    // Creates the JPanel that represents the PlayFrame.
    public JPanel createPlayPanel() {
        // Create a JPanel using GridBagLayout for organized positioning of components.
        JPanel questionPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();  // GridBagConstraints to define layout behavior for each component.

        // Create and setup the label for the question.
        JLabel questionLabel = new JLabel("Who wants to be a millionaire?");
        questionLabel.setFont(new Font(Font.SERIF, Font.BOLD, 25));  // Set the font style and size for the label.
        questionLabel.setHorizontalAlignment(JLabel.CENTER);  // Center the text in the label.
        questionLabel.setPreferredSize(new Dimension(600, 300));  // Set preferred size for the label.
        questionLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));  // Add some space below the label.

        // Create and setup the button for the "ME!" action.
        JButton questionButton = new JButton("ME!");
        questionButton.setFont(new Font(Font.SERIF, Font.BOLD, 20));  // Set the font for the button.
        questionButton.setPreferredSize(new Dimension(100, 30));  // Set the preferred size for the button.
        questionButton.setFocusable(false);  // Ensure button doesn't gain focus when clicked.

        // Add ActionListener to handle the button click event.
        questionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // When the button is clicked, switch to the AskUserName panel using CardLayout.
                mainClass.showPanel("AskUserName");
            }
        });

        // Define the layout positions for the question label and button using GridBagConstraints.
        gbc.gridx = 0;  // Position the question label at column 0.
        gbc.gridy = 0;  // Position the question label at row 0.
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Make the label stretch horizontally.
        questionPanel.add(questionLabel, gbc);  // Add the question label to the panel.

        gbc.gridx = 0;  // Position the button at column 0.
        gbc.gridy = 1;  // Position the button at row 1.
        gbc.fill = GridBagConstraints.NONE;  // Do not stretch the button.
        gbc.anchor = GridBagConstraints.CENTER;  // Center the button.
        questionPanel.add(questionButton, gbc);  // Add the button to the panel.

        // Create a padded panel to add extra space around the question panel.
        JPanel paddedPanel = new JPanel(new BorderLayout());  
        paddedPanel.setBorder(BorderFactory.createEmptyBorder(200, 100, 200, 100));  // Add padding around the panel.
        paddedPanel.add(questionPanel, BorderLayout.CENTER);  // Add the question panel to the center of the padded panel.

        return paddedPanel;  // Return the fully constructed panel.
    }
}
