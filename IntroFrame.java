import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntroFrame {
    private Main mainClass;  // Reference to the Main class, allowing interaction with the rest of the application.

    // Constructor that initializes the IntroFrame with a reference to the Main class.
    public IntroFrame(Main mainClass) {
        this.mainClass = mainClass;
    }

    // Creates the JPanel that represents the intro screen.
    public JPanel createIntroPanel() {
        // Create intro screen panel with BorderLayout to organize components (title, logo, button).
        JPanel introPanel = new JPanel(new BorderLayout());
        
        // Set up the title label.
        JLabel titleLabel = new JLabel("Who Wants To Be A Millionaire!");
        titleLabel.setFont(new Font(Font.SERIF, Font.BOLD, 25));  // Set font style and size for the title.
        titleLabel.setHorizontalAlignment(JLabel.CENTER);  // Center the text in the label.
        titleLabel.setBorder(BorderFactory.createEmptyBorder(45, 0, 0, 0));  // Add spacing above the title label.

        // Logo placeholder
        Logo logo = new Logo();  // Logo is another class that displays an image ug animation.
        JPanel introAnimationPanel = new JPanel(new BorderLayout());
        introAnimationPanel.add(logo, BorderLayout.CENTER);  // Add the logo to the center of the panel.

        // Adding title and logo to the intro panel.
        introPanel.add(titleLabel, BorderLayout.NORTH);  // Title at the top of the panel.
        introPanel.add(introAnimationPanel, BorderLayout.CENTER);  // Logo/Animation in the center.

        // Play Button setup.
        JButton playButton = new JButton("Play");
        playButton.setFont(new Font(Font.SERIF, Font.BOLD, 25));  // Set font style and size for the button.
        playButton.setBackground(new Color(158, 114, 195, 1));  // Set button background color.
        playButton.setFocusable(false);  // Ensure button does not gain focus when clicked.
        playButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));  // Add spacing below the button.

        // ActionListener for the play button to switch to the PlayFrame.
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to PlayFrame panel using CardLayout from the Main class.
                mainClass.showPanel("PlayFrame");
            }
        });

        // Add the play button to the intro panel.
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(playButton);  // Add play button to the flow layout panel.
        introPanel.add(buttonsPanel, BorderLayout.SOUTH);  // Place the button at the bottom of the panel.

        return introPanel;  // Return the fully constructed intro panel.
    }
}
