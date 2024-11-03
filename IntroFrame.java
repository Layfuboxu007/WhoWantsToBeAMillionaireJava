import javax.swing.*;
import java.awt.*;

class IntroFrame {
    public void intro() {
        JFrame intro = new JFrame("Who Wants To Be A Millionaire");

        intro.setSize(800, 800);
        intro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        intro.setLocationRelativeTo(null);
        intro.setResizable(false);

        JPanel introPanel = new JPanel();
        introPanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Who wants to be a millionaire!");
        Font titleLabelFont = new Font(Font.SERIF, Font.BOLD, 30);
        titleLabel.setFont(titleLabelFont);    
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(45, 0, 0, 0));

        Logo logo = new Logo();

        JPanel introAnimationPanel = new JPanel();
        introAnimationPanel.setLayout(new BorderLayout());
        introAnimationPanel.add(logo, BorderLayout.CENTER);

        introPanel.add(titleLabel, BorderLayout.NORTH);
        introPanel.add(introAnimationPanel, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        JButton playButton = new JButton("Play");
        playButton.setFont(new Font(Font.SERIF, Font.BOLD, 25)); 
        playButton.setBackground(new Color(158, 114, 195, 1)); 
        playButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
        playButton.setFocusable(false);

        buttonsPanel.add(playButton);

        introPanel.add(buttonsPanel, BorderLayout.SOUTH);

        intro.add(introPanel);
        intro.setVisible(true);
    }
}
