import javax.swing.*;
import java.awt.*;

public class PlayFrame {
    public JPanel createPlayPanel() {
        // Panel for play screen with GridBagLayout for organized positioning.
        JPanel questionPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Question label setup.
        JLabel questionLabel = new JLabel("Who wants to be a millionaire?");
        questionLabel.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        questionLabel.setHorizontalAlignment(JLabel.CENTER);
        questionLabel.setPreferredSize(new Dimension(600, 300));
        questionLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));

        // ME button setup.
        JButton questionButton = new JButton("ME!");
        questionButton.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        questionButton.setPreferredSize(new Dimension(100, 30));
        questionButton.setFocusable(false);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        questionPanel.add(questionLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        questionPanel.add(questionButton, gbc);

        // Wrapping question panel in a padded panel.
        JPanel paddedPanel = new JPanel(new BorderLayout());
        paddedPanel.setBorder(BorderFactory.createEmptyBorder(200, 100, 200, 100));
        paddedPanel.add(questionPanel, BorderLayout.CENTER);

        return paddedPanel;  // Return ready-to-use play panel.
    }
}
