import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JFrameText implements FrameManager {

    private JFrame frame;
    private JPanel panel;
    private JTextField textField;
    private JLabel label;

    public JFrameText(){
        initialize();
    }

    private void initialize(){
        frame = new JFrame();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Big Text Title");
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(wl());

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        textField = jtext();
        panel.add(textField);

        label = new JLabel();
        panel.add(label);

        frame.add(panel);
    }

    private JTextField jtext(){
        textField = new JTextField(21);

        textField.setFont(new Font("Times new Roman", Font.BOLD, 14));

        textField.setForeground(Color.RED);

        textField.setBackground(Color.GREEN);

        textField.setToolTipText("E");

        textField.setMargin(new Insets(10, 10, 10, 10));

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textMagic();
            }
        });

        return textField;
    }

    private void textMagic(){
        label.setText(textField.getText());
        textField.setText("");
    }

    public void show(){
        frame.setVisible(true);
    }

}
