import javax.swing.*;
import java.awt.*;

class PlayFrame {
    public void openPlayFrame() {
        JFrame play = new JFrame("Welcome to Who Wants To Be A Millionaire!");
        play.setSize(800, 800);
        play.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        play.setLocationRelativeTo(null);
        play.setResizable(false);

        JPanel questionPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel questionLabel = new JLabel("Who wants to be a millionaire?");
        questionLabel.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        questionLabel.setHorizontalAlignment(JLabel.CENTER);
        questionLabel.setPreferredSize(new Dimension(600, 300));
        questionLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));

        JButton questionButton = new JButton("ME!");
        questionButton.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        questionButton.setPreferredSize(new Dimension(100, 30)); 
        questionButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL; 
        questionPanel.add(questionLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        questionPanel.add(questionButton, gbc);

        JPanel paddedPanel = new JPanel(new BorderLayout());
        paddedPanel.setBorder(BorderFactory.createEmptyBorder(200, 100, 200, 100));
        paddedPanel.add(questionPanel, BorderLayout.CENTER);

        play.add(paddedPanel, BorderLayout.CENTER);
        play.setVisible(true);
    }
}
