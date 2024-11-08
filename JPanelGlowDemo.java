import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class JPanelGlowDemo
{
   JFrame f;
   JPanel p;
   
   public void runUI()
   {
      f = new JFrame("Glowing Panel Demo");
      p = new JPanel();
      
      p.setBackground(Color.LIGHT_GRAY);
      p.addMouseListener(new PanelMouseListener());
      p.setPreferredSize(new Dimension(200, 200));
      
      f.setLayout(new FlowLayout());
      
      f.add(p);
      
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
   
   public static void main(String[] args)
   {
      JPanelGlowDemo demo = new JPanelGlowDemo();
      
      demo.runUI();
   }
}