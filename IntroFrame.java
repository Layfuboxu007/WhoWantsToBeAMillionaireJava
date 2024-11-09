import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntroFrame {
    private Main mainClass;

    public IntroFrame(Main mainClass) {
        this.mainClass = mainClass;
    }

    public JPanel createIntroPanel() {
        
        // Create intro screen panel.
        JPanel introPanel = new JPanel(new BorderLayout());
        
        // Set up title label
        JLabel titleLabel = new JLabel("Who Wants To Be A Millionaire!");
        titleLabel.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(45, 0, 0, 0));

        // Logo placeholder (another class)
        Logo logo = new Logo();
        JPanel introAnimationPanel = new JPanel(new BorderLayout());
        introAnimationPanel.add(logo, BorderLayout.CENTER);

        // Adding title and logo to intro panel
        introPanel.add(titleLabel, BorderLayout.NORTH);
        introPanel.add(introAnimationPanel, BorderLayout.CENTER);

        // Play Button setup and listener for screen change
        JButton playButton = new JButton("Play");
        playButton.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        playButton.setBackground(new Color(158, 114, 195, 1));
        playButton.setFocusable(false);
        playButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to PlayFrame panel using CardLayout.
                mainClass.showPanel("PlayFrame");
            }
        });

        // Adding button to intro panel.
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(playButton);
        introPanel.add(buttonsPanel, BorderLayout.SOUTH);

        return introPanel;
    }
}
