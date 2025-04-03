import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame{
    private JFrame frame;
    private JPanel panel;

    private JButton act;
    private JButton butts;
    private JButton good;
    private JButton grid;
    private JButton menu;
    private JButton text;

    private FrameManager[] fm = new FrameManager[6];


    public MainFrame(){
        initialize();
    }

    private void initialize(){
        frame = new JFrame();
        frame.setResizable(false);
        frame.setSize(600, 400);
        frame.setTitle("MotherFrame");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();

        // links to other pages
        fm[0] = new JFrameACT();
        fm[1] = new JFrameGood();
        fm[2] = new JFrameGrid();
        fm[3] = new JFrameButtons();
        fm[4] = new JFrameText();
        fm[5] = new JFrameMenu();

        act = btn("ACT", 0);
        good = btn("Good", 1);
        grid = btn("Grid", 2);
        butts = btn("Buttonss", 3);
        text = btn("Text", 4);
        menu = btn("Menu", 5);
        //

        panel.add(act);
        panel.add(butts);
        panel.add(good);
        panel.add(grid);
        panel.add(menu);
        panel.add(text);

        frame.add(panel);

        // On 'x' press
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                int i = JOptionPane.showConfirmDialog(null, "Are you really leaving me?\nAlone. In the darkness.");
                if(i == 0)
                    System.exit(0);
            }
        });
    }

    private JButton btn(String text, int type){
        JButton button = new JButton(text);
        button.setFocusable(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fm[type].show();
                frame.dispose();
            }
        });

        return button;
    }

    public void show(){
        frame.setVisible(true);
    }
}
