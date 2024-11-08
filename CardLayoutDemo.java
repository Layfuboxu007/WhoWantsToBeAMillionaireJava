import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class CardLayoutDemo
{
   JFrame f;
   JPanel pnlHome;
   JPanel pnlGame;
   JButton btnGame;
   JButton btnHome;
   CardLayout crdLayout;
   Container mainContainer;
   
   public void runUI()
   {
      f = new JFrame("CardLayout Demo");
      crdLayout = new CardLayout();
      pnlHome = new JPanel();
      pnlGame = new JPanel();
      btnGame = new JButton("Start Game");
      btnHome = new JButton("Exit");
      
      f.setLayout(crdLayout);
      mainContainer = f.getContentPane();
      
      btnGame.setActionCommand("game");
      btnHome.setActionCommand("home");
      
      btnGame.addActionListener(new ButtonClickListener());
      btnHome.addActionListener(new ButtonClickListener());
      
      pnlHome.setBackground(Color.LIGHT_GRAY);
      pnlHome.addMouseListener(new PanelMouseListener());
      pnlHome.add(btnGame);
      
      pnlGame.setBackground(Color.BLUE);
      pnlGame.addMouseListener(new PanelMouseListener());
      pnlGame.add(btnHome);
            
      f.add("home", pnlHome);
      f.add("game", pnlGame);
      
      f.setSize(400, 400);
      f.setResizable(false);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
   }
   
   private class PanelMouseListener implements MouseListener
   {
      private Border coloredBorder = BorderFactory.createLineBorder(Color.CYAN);
      
      public void mouseEntered(MouseEvent e)
      {
         JPanel panel = (JPanel)e.getSource();
         panel.setBorder(coloredBorder);
         panel.revalidate();
      }
      
      public void mouseExited(MouseEvent e)
      {
         JPanel panel = (JPanel)e.getSource();
         panel.setBorder(null);
         panel.revalidate();
      }
      
      public void mousePressed(MouseEvent e) {}
      public void mouseReleased(MouseEvent e) {}
      public void mouseClicked(MouseEvent e) {}
   }
   
   private class ButtonClickListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         switch(e.getActionCommand())
         {
            case "home":
               crdLayout.show(mainContainer, "home");
            break;
            case "game":
               crdLayout.show(mainContainer, "game");
            break;
         }
      }
   }
   
   public static void main(String[] args)
   {
      CardLayoutDemo demo = new CardLayoutDemo();
      
      demo.runUI();
   }
}