import java.util.Timer;
import java.util.TimerTask;

public class CustTimer {
    Timer chrono;

    public CustTimer(){
        initialize();
    }

    private void initialize(){
        chrono = new Timer();
        chrono.schedule(new TimerTask() { // (task, delay act, delay rep)

            int time = 0;

            @Override
            public void run() {
                System.out.println("Here's the time : " + time);

                if(time == 5) cancel();

                time++;
            }
            
        }, 1000, 1000); 
    }
}
