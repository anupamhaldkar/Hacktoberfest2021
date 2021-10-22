import board.*;;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class MissileShooting extends JFrame {

    public MissileShooting() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setSize(700,700);
        setTitle("Missile Shooting");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            MissileShooting ex = new MissileShooting();
            ex.setVisible(true);
        });
    }
}
