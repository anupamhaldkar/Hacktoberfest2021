import board.*;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class DonutExample extends JFrame {

    public DonutExample()
    {

        initUI();
    }

    private void initUI()
    {
      Board bd=new Board();

        add(bd);

        setSize(330, 330);

        setTitle("Donut");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            DonutExample ex = new DonutExample();
            ex.setVisible(true);
        });
    }
}
