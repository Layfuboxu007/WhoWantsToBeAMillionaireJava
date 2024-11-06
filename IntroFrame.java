import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class IntroFrame {
    public void runUI() {
        PlayFrame play = new PlayFrame();

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

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        JButton playButton = new JButton("Play");
        playButton.setFont(new Font(Font.SERIF, Font.BOLD, 25)); 
        playButton.setBackground(new Color(158, 114, 195, 1)); 
        playButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
        playButton.setFocusable(false);

        JButton replaceButton = new JButton("Replace");
        replaceButton.setFont(new Font(Font.SERIF, Font.BOLD, 25)); 
        replaceButton.setBackground(new Color(158, 114, 195, 1)); 
        replaceButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
        replaceButton.setFocusable(false);

        buttonsPanel.add(playButton);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                intro.getContentPane().removeAll();
                play.openPlayUI(intro);
            }
        });

        introPanel.add(buttonsPanel, BorderLayout.SOUTH);

        intro.add(introPanel);
        intro.setVisible(true);
    }
}
