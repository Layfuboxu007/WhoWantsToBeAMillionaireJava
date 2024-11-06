import javax.swing.*;
import java.awt.*;

class PlayFrame {
    public void openPlayUI(JFrame frame) {
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

        JButton replaceButton = new JButton("Replace");
        replaceButton.setFont(new Font(Font.SERIF, Font.BOLD, 25)); 
        replaceButton.setFocusable(false);

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

        frame.add(paddedPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }
}
