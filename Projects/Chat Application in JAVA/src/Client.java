import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

public class Client extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JPanel upper_panel;
    JTextField text_field;
    JButton send_button;
    static JTextArea chat_textarea;
    static Socket s;
    static DataOutputStream dos;
    static DataInputStream dis;

    Boolean typing = false;

    Client() {

        upper_panel = new JPanel();
        upper_panel.setLayout(null);
        upper_panel.setBackground(new Color(7, 94, 84));
        upper_panel.setBounds(0, 0, 450, 70);
        add(upper_panel);

        // BACK BUTTON
        ImageIcon back_button = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        final Image i1 = back_button.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        back_button = new ImageIcon(i1);
        final JLabel back_button_label = new JLabel(back_button);
        back_button_label.setBounds(5, 17, 30, 30);
        upper_panel.add(back_button_label);// Adding image back_button above panel upper_panel
        back_button_label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent ae) {
                System.exit(0);
            }
        });

        // PROFILE PICTURE
        ImageIcon profile_picture = new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));
        final Image i2 = profile_picture.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        profile_picture = new ImageIcon(i2);
        final JLabel profile_picture_label = new JLabel(profile_picture);
        profile_picture_label.setBounds(40, 5, 60, 60);
        upper_panel.add(profile_picture_label);// Adding image profile_picture above panel upper_panel

        // NAME
        JLabel user_name = new JLabel("User 2");
        user_name.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        user_name.setForeground(Color.WHITE);
        user_name.setBounds(110, 15, 100, 18);
        upper_panel.add(user_name);// Adding image

        // ACTIVE STATUS
        final JLabel user_status = new JLabel("Active Now");
        user_status.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        user_status.setForeground(Color.WHITE);
        user_status.setBounds(110, 35, 100, 20);
        upper_panel.add(user_status);

        Timer t = new Timer(1, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (!typing) {
                    user_status.setText("Active Now");
                }
            }
        });
        t.setInitialDelay(2000);

        // CHAT TEXT AREA
        chat_textarea = new JTextArea();
        // chat_textarea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        chat_textarea.setLineWrap(true);
        chat_textarea.setWrapStyleWord(true);
        chat_textarea.setBounds(5, 75, 440, 575);
        chat_textarea.setBackground(new Color(0, 255, 179));// Light Green
        chat_textarea.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        chat_textarea.setEditable(false);
        add(chat_textarea);

        // TEXT FIELD
        text_field = new JTextField();
        text_field.setBounds(5, 655, 330, 40);
        text_field.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(text_field);

        text_field.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                user_status.setText("typing....");
                t.stop();
                typing = true;
            }

            public void keyReleased(KeyEvent e) {
                typing = false;
                if (!t.isRunning()) {
                    t.start();
                }
            }
        });

        // SEND BUTTON
        send_button = new JButton("Send");
        send_button.setBounds(340, 655, 100, 40);
        send_button.setBackground(new Color(7, 94, 84));
        send_button.setForeground(Color.WHITE);
        send_button.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        send_button.addActionListener(this);
        add(send_button);

        setLayout(null);
        setSize(450, 700);
        setLocation(1100, 200);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String message = text_field.getText();
        try {
            chat_textarea.setText(chat_textarea.getText() + "\n" + message);
            chat_textarea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            text_field.setText("");
            dos.writeUTF(message);

        } catch (Exception e) {
        }
    }

    public static void main(final String[] args) throws IOException {
        new Client().setVisible(true);

        try {
            s = new Socket("localhost", 11111);

            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());
            String message = "";
            while (true) {
                message = dis.readUTF();
                chat_textarea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                chat_textarea.setText(chat_textarea.getText() + "\n" + message);
                System.out.println(message);
            }
        } catch (Exception e) {

        }

    }

}
