import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

public class JFrameButts implements FrameManager {

    private JFrame frame;
    private JPanel panel;
    private JButton butt;
    private JLabel label;

    public JFrameButts(){
        initialize();
    }

    private void initialize(){
        frame = new JFrame();
        frame.setTitle("Big Butts Title");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(400, 200));
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        frame.addWindowListener(wl());


        panel = new JPanel(new MigLayout("wrap", "[]", "[][]"));
        panel.setBackground(Color.BLACK);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        butt = createButt();
        
        // Label
        label = new JLabel("I'm half white, other hal...");
        label.setForeground(Color.WHITE); // text color

        ImageIcon labelIcon = new ImageIcon("rsc/img/the_shiny.png");
        label.setIcon(labelIcon);
        label.setHorizontalTextPosition(SwingConstants.LEFT);
        //

        panel.add(butt);
        panel.add(label, BorderLayout.CENTER);

        frame.add(panel);
    }

    private JButton createButt(){
        JButton butt = new JButton("Touch me~");
        butt.setFocusable(false);

        ImageIcon icon = new ImageIcon("rsc/img/gem_or_something.png");
        butt.setIcon(icon);
        butt.setIconTextGap(10);

        butt.setMnemonic(KeyEvent.VK_UP); // alt+up -> button press

        butt.setToolTipText("That's a nice butt right there");

        butt.setFont(new Font("Times New Roman", Font.ITALIC, 18));

        butt.setMargin(new Insets(10, 10, 10, 10));

        // func of button
        butt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttPhonk("Mh~ That tickles ^^");
            }
        });

        //butt.setEnabled(false);

        //butt.doClick();

        //butt.setVerticalTextPosition(SwingConstants.BOTTOM);
        //butt.setHorizontalTextPosition(SwingConstants.CENTER);

        return butt;
    }

    private void buttPhonk(String text){
        System.out.println(text);
    }

    public void show(){
        frame.setVisible(true);
    }
}
