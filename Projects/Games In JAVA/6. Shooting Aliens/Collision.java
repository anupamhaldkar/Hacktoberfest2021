import board.*;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class Collision extends JFrame
{
  public Collision()
  {
    initUI();
  }

  private void initUI()
  {
    add(new Board());
    setResizable(false);
    pack();

    setTitle("Collision");
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(()->{
      Collision ex= new Collision();
      ex.setVisible(true);
    });
  }
}
