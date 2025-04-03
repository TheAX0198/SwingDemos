import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Main {
    public static void main(String[] args) throws Exception {

        // run on "Event Dispach Thread (EDT)" - thread to draw UI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                lookNFeel("Nimbus");

                MainFrame mainFrame = new MainFrame();
                mainFrame.show();
            }
        });
    }


    // JFrame comps skin | In this case : "Nimbus"
    private static void lookNFeel(String look){
        for(LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            if (look.equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            }
        }
    }
}
