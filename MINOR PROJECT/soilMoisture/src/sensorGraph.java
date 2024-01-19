import edu.princeton.cs.introcs.StdDraw;
import org.firmata4j.Pin;
import org.firmata4j.ssd1306.SSD1306;
import java.util.HashMap;
import java.util.TimerTask;

public class sensorGraph extends TimerTask {

    private final SSD1306 myOLED;

    private Pin sensor;

    private Pin pump;

    private int a;

    sensorGraph(SSD1306 myOLED, Pin sensor, Pin pump) {

        this.myOLED = myOLED;
        this.sensor = sensor;
        this.pump = pump;
        a=0;

    }
    @Override
    public void run(){
        HashMap<Integer,Integer> myPairs = new HashMap<>();

        while(true){
            if (sensor.getValue()>=700){

                try{
                    String moist_lv = String.valueOf(sensor.getValue());
                    myOLED.getCanvas().clear();
                    myOLED.getCanvas().setTextsize(2);
                    myOLED.getCanvas().drawString(0,0,moist_lv+"moisture is too low");
                    myOLED.display();
                    pump.setValue(1);
                }
                catch (Exception ex)
                {

                }
            }
            else if (590<= sensor.getValue() && sensor.getValue()<= 700){
                try{
                    String moist_lv = String.valueOf(sensor.getValue());
                    myOLED.getCanvas().clear();
                    myOLED.getCanvas().setTextsize(2);
                    myOLED.getCanvas().drawString(0,0,moist_lv+"moisture level could bve beter");
                    myOLED.display();
                    pump.setValue(1);

                }catch (Exception ex){

                }
            }
            else {
                try{
                    String moist_lv = String.valueOf(sensor.getValue());
                    myOLED.getCanvas().clear();
                    myOLED.getCanvas().setTextsize(2);
                    myOLED.getCanvas().drawString(0,0,moist_lv+"moisture level is just right");
                    myOLED.display();
                    pump.setValue(1);
                } catch (Exception ex){

                }
            }
            myPairs.put(a,(int) sensor.getValue());


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

            a+=5;
        }
    }
}