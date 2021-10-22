import board.*;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class SwingTimer extends JFrame
{
  public SwingTimer()
  {
    initUI();
  }

  private void initUI()
  {
    add(new Board());

    pack();

    setTitle("Star");
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(()-> {
      SwingTimer st= new SwingTimer();
      st.setVisible(true);
    });
  }
}
