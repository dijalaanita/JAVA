

import edu.princeton.cs.introcs.StdDraw;
import org.firmata4j.Pin;
import org.firmata4j.ssd1306.SSD1306;

import java.util.HashMap;
import java.util.TimerTask;

public class HD extends TimerTask {

    private final SSD1306 myOLED;

    private Pin mySensor;

    private Pin myPump;

    private int j;

    HD(SSD1306 myOLED, Pin mySensor, Pin myPump) {

        this.myOLED = myOLED;
        this.mySensor = mySensor;
        this.myPump = myPump;
        j=0;

    }
    @Override
    public void run(){
        HashMap<Integer,Integer> myPairs = new HashMap<>();

        while(true){
            if (mySensor.getValue()>=700){

                try{
                    String moist_lv = String.valueOf(mySensor.getValue());
                    myOLED.getCanvas().clear();
                    myOLED.getCanvas().setTextsize(2);
                    myOLED.getCanvas().drawString(0,0,moist_lv+"moisture is to low");
                    myOLED.display();
                    myPump.setValue(1);
                }catch (Exception ex){

                }
            }
            else if (590<= mySensor.getValue() && mySensor.getValue()<= 700){
                try{
                    String moist_lv = String.valueOf(mySensor.getValue());
                    myOLED.getCanvas().clear();
                    myOLED.getCanvas().setTextsize(2);
                    myOLED.getCanvas().drawString(0,0,moist_lv+"moisture level could bve beter");
                    myOLED.display();
                    myPump.setValue(1);

                }catch (Exception ex){

                }
            }
            else {
                try{
                    String moist_lv = String.valueOf(mySensor.getValue());
                    myOLED.getCanvas().clear();
                    myOLED.getCanvas().setTextsize(2);
                    myOLED.getCanvas().drawString(0,0,moist_lv+"moisture level is just right");
                    myOLED.display();
                    myPump.setValue(1);
                } catch (Exception ex){

                }
            }
            myPairs.put(j,(int)mySensor.getValue());


            myPairs.forEach((xValue, yValue) -> StdDraw.text(xValue,yValue,"#"));
            StdDraw.setXscale(0,500);

            StdDraw.setPenRadius(0.005);
            StdDraw.setYscale(0,1023);
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.line(0,0,0,1023);
            StdDraw.line(0,0,500,0);
            StdDraw.setPenColor(StdDraw.DARK_GRAY);
            StdDraw.text(-10,540,"V");
            StdDraw.text(-10,505,"o");
            StdDraw.text(-10,470,"l");
            StdDraw.text(-10,435,"t");
            StdDraw.text(-10,400,"s");
            StdDraw.text(-10,360,"[v]");
            StdDraw.text(-7,1030,"1023");
            StdDraw.text(0,-19,"0");
            StdDraw.text(250,-30,"Time[s]");
            StdDraw.text(480,-30,"500");
            StdDraw.text(500,1100,"voltage vs timegraph");


            StdDraw.show();

            j+=5;
        }
    }
}
