import java.util.Timer;
import java.util.TimerTask;
public class LabC_PtB {public static void   main(String[]  args){

    Timer obj = new Timer();
    obj.schedule(new TimerTask() {
        int i = 0;

        @Override
        public void run() {
            System.out.println("Counter is: " + i);
            i = i + 1;
            System.out.println(System.currentTimeMillis() + " Milleseconds");

        }

    } , 0, 1000);

}
}