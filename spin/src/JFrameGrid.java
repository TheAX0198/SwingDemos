import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameGrid implements FrameManager {

    private JFrame frame;
    private JPanel panel;

    public JFrameGrid(){
        initialize();
    }

    private void initialize(){
        frame = new JFrame();
        frame.setTitle("Big Grid Title");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setMinimumSize(new Dimension(400, 200));
        frame.addWindowListener(wl());

        final int col = 4;
        final int row = 5;

        panel = new JPanel(new GridLayout(col, row, 10, 10)); // {row, col, hgap, vgap}
        for(int i = 0; i < (col*row); i++){
            JButton button = new JButton(Integer.toString(i));
            panel.add(button);
        }

        frame.add(panel);

        frame.setLocationRelativeTo(null);
    }

    public void show(){
        frame.setVisible(true);
    }
}
