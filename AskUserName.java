import javax.swing.*;
import java.awt.*;

public class AskUserName {
    private Main mainClass;

    public AskUserName(Main mainClass) {
        this.mainClass = mainClass;
    }
    public JPanel createUserNameUI() {
        JPanel userPanel = new JPanel();

        JPanel labelPanel = new JPanel();
        labelPanel.setBorder(BorderFactory.createEmptyBorder(70, 0, 0, 0));

        JLabel labelUser = new JLabel("Please enter your name: ");
        labelUser.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
        labelUser.setHorizontalAlignment(JLabel.CENTER);

        labelPanel.add(labelUser, BorderLayout.CENTER);

        userPanel.add(labelPanel, BorderLayout.NORTH);

        return userPanel;
    }
}
