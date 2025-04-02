import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;

import net.miginfocom.swing.MigLayout;

public class JFrameMenu implements FrameManager {
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenu archMenuFile;
    
    private JPanel panel;
    private JCheckBox checkBox;
    
    private JMenuItem item1;
    private JMenuItem item2;
    private JMenuItem item3;
    
    private JMenuItem arch1;


    public JFrameMenu(){
        initialize();
    }

    private void initialize(){
        frame = new JFrame();
        frame.setTitle("Big Menu Title");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setIconImage(newIco("expension_of_light.png").getImage()); // change frame icon
        //frame.setUndecorated(true); // remove title bar
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(wl());
        

        // font for comps
        Font f = new Font("Times New Roman", Font.PLAIN, 16);
        UIManager.put("Menu.font", f);
        UIManager.put("MenuItem.font", f);
        UIManager.put("CheckBoxMenuItem.font", f);
        UIManager.put("RadioButtonMenuItem.font", f);
        //


        // menu comps
        menuBar = new JMenuBar();

        menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_M);

            // menu
        item1 = new JMenuItem("Klu");
        item1.setIcon(newIco("molden_nature.png"));
        item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        item1.addActionListener(newAct("Klu"));

        item2 = new JMenuItem("Klux");
        item2.setIcon(newIco("gem_or_something.png"));
        item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        item2.addActionListener(newAct("Klux"));

        item3 = new JMenuItem("Klan");
        item3.setIcon(newIco("the_shiny.png"));
        item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        item3.addActionListener(newAct("Klan"));

        menuFile.add(item1);
        menuFile.add(item2);
        menuFile.add(item3);

        menuFile.add(new JRadioButtonMenuItem("Vault 420"));
        menuFile.add(new JCheckBoxMenuItem("Check mate"));

            // sub menu
        arch1 = new JMenuItem("file_1");
        arch1.setIcon(newIco("brain.png"));
        arch1.addActionListener(newAct("The bite of '87"));

        archMenuFile = new JMenu("Archive");
        archMenuFile.add(arch1);

        menuFile.addSeparator(); 
        menuFile.add(archMenuFile);

        menuBar.add(menuFile);

        frame.add(menuBar, BorderLayout.NORTH);
        //

        // panel comps
        panel = new JPanel(new MigLayout("center", "[center]", ""));

            // checkBox 
        checkBox = new JCheckBox();
        checkBox.setText("Turn me on~");
        checkBox.setFocusable(false);

        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected()) {
                    System.out.println("You're such a tease uwu");
                }
            }
        });

            // table
        Object[] nameCol = {"One", "Two", "Three"};
        Object[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        JTable table = new JTable(data, nameCol);
        table.setEnabled(false);

        JTableHeader headers = table.getTableHeader();
        headers.setEnabled(false);

        panel.add(checkBox);
        panel.add(headers, "newLine");
        panel.add(table, "newLine");

        frame.add(panel);
        //
    }

    // create action obj
    private ActionListener newAct(String msg){
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(msg);
            }
        };
        return action;
    }

    // create icon obj
    private ImageIcon newIco(String iconPath){
        ImageIcon imgIcon = new ImageIcon("rsc/img/" + iconPath);
        return imgIcon;
    }

    // display frame
    public void show(){
        frame.setVisible(true);
    }
}
