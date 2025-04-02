import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public interface FrameManager {
    void show();

    default WindowListener wl(){
        WindowListener winLstn = new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {
                MainFrame mainFrame = new MainFrame();
                mainFrame.show();
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        };

        return winLstn;
    }
}
