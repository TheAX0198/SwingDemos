import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame; // CONTAINER
import javax.swing.JPanel; // CONTAINER

// this one's more secure because
// it doesn't expose itself to the whole program
public class JFrameGood implements FrameManager {

    private JFrame frame;

    public JFrameGood(){
        initialize();
    }

    private void initialize(){
        frame = new JFrame();
        frame.setTitle("Big Good Title");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout(5, 5)); // add margin to comps
        frame.addWindowListener(wl());
        
        // "BorderLayout" can be used in any container
        frame.add(creatButton("NORTH", Color.GRAY), BorderLayout.NORTH);
        frame.add(creatButton("SOUTH", Color.GRAY), BorderLayout.SOUTH);
        frame.add(creatButton("WEST", Color.GRAY), BorderLayout.WEST);
        frame.add(creatButton("EAST", Color.GRAY), BorderLayout.EAST);
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5)); // {align comps (like "display flex"), horizGap w/ other comp, vertiGap w/ other comp}

        panel.setBackground(Color.BLACK);

        // Buttons
        JButton button = new JButton("I am a button");
        button.setBackground(Color.GRAY);
        panel.add(button);

        JButton button1 = new JButton("I also am a button");
        button1.setBackground(Color.GRAY);
        panel.add(button1);

        JButton button2 = new JButton("Me too!");
        button2.setBackground(Color.GRAY);
        panel.add(button2);
        //

        //panel.setPreferredSize(new Dimension(200, 100)); // adjust size (like in css) only if not BorderLayout = center

        frame.add(panel, BorderLayout.CENTER); // north/south/west/east
        
        frame.setLocationRelativeTo(null); // open in middle
    }

    private JButton creatButton(String text, Color bg){
        JButton button = new JButton(text);
        button.setBackground(bg);
        return button;
    }

    public void show(){
        frame.setVisible(true);
    }

}
