import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Logo extends JPanel {
    private BufferedImage logoImage;
    private Timer animationTimer;
    private int glowRadius = 400;
    private boolean increasing = true;

    public Logo() {
        // Load the logo image
        try {
            logoImage = ImageIO.read(new File("logo.png"));
        } catch (IOException e) {
            System.out.println("Logo image not found. Make sure 'logo.png' is in the directory.");
        }

        // Set the panel to be transparent
        setOpaque(false);

        // Timer for animation effect
        animationTimer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pulsating effect by adjusting glow radius
                if (increasing) {
                    glowRadius += 4;
                    if (glowRadius >= 360) increasing = false;
                } else {
                    glowRadius -= 4;
                    if (glowRadius <= 300) increasing = true;
                }
                repaint(); // Repaint the panel to update animation
            }
        });

        animationTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Enable anti-aliasing for smoother glow
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw animated blue glow in the center
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        for (int i = 0; i < 5; i++) {
            int alpha = (int) (255 * (1.0 - (i * 0.2))); // Adjust transparency for layers
            g2d.setColor(new Color(0, 0, 255, alpha));
            int radius = glowRadius + i * 30;
            g2d.fillOval(centerX - radius / 2, centerY - radius / 2, radius, radius);
        }

        // Draw logo image in the center
        if (logoImage != null) {
            int logoX = centerX - logoImage.getWidth() / 2;
            int logoY = centerY - logoImage.getHeight() / 2;
            g2d.drawImage(logoImage, logoX, logoY, null);
        }
    }

    
}
