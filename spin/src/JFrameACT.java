import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import net.miginfocom.swing.MigLayout;

public class JFrameACT implements FrameManager {

    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JLabel label;
    private JPasswordField passField;
    private MigLayout ml = new MigLayout("wrap, debug", "[]", "[][][]");

    public final int WIDTH = 600;
    public final int HEIGHT = 400;

    private int ctr = -1;

    public JFrameACT(){
        initialize();
    }

    private void initialize(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Big ACT Title");
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(wl());

        frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 0, HEIGHT/4));

        panel = new JPanel(ml); // "wrap" -> comps in row/col position, [] -> row/col, []25[] -> margin between row/col

        label = new JLabel("Enter dat DATA (that I won't steal) :");

        passField = new JPasswordField(20);
        passField.setEchoChar('@'); // change hidden char * by other char

        button = jButton();

        addToPan();

        frame.add(panel);
    }

    private void addToPan(){
        panel.add(label);
        panel.add(passField);
        panel.add(button, BorderLayout.CENTER); // "BorderLayout.CENTER" truly centers content
    }

    private JButton jButton(){
        button = new JButton("Save");
        button.setFocusable(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcButton();
            }
        });
        
        return button;
    }

    private void funcButton(){
        ctr++;
        char[] charPwd = passField.getPassword();
        String pwd = new String(charPwd);

        System.out.println(ctr + " -> " + pwd);
        passField.setText(null);

        // debug mode
        if (pwd.equals("!nd")) {
            frame.remove(panel);
            ml = new MigLayout("wrap", "[]", "[][][]");
            panel = new JPanel(ml);
            addToPan();
            frame.add(panel);
            frame.revalidate(); // refresh frame

        } else if(pwd.equals("!d")){
            frame.remove(panel);
            ml = new MigLayout("wrap, debug", "[]", "[][][]");
            panel = new JPanel(ml);
            addToPan();
            frame.add(panel);
            frame.revalidate();
        }
    }

    public void show(){
        frame.setVisible(true);
    }
}
