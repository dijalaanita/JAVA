import org.firmata4j.Pin;
import org.firmata4j.ssd1306.SSD1306;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class soilMoisture extends TimerTask {
    private final SSD1306 OLEDObj;
    private final Pin moisture;
    private final Pin pump;
    private final Timer timer;
    private final Pin button;
    private final Pin LED;
    // constructor
    public soilMoisture(Timer timer, Pin pump, Pin moisture, Pin button, SSD1306 OLEDObj, Pin LED) {
        this.moisture = moisture;
        this.OLEDObj = OLEDObj;
        this.pump = pump;
        this.timer = timer;
        this.button = button;
        this.LED = LED;
    }

    @Override
    public void run() {
        try {
            while(this.button.getValue() != 1){
                this.OLEDObj.getCanvas().clear();
                OLEDObj.getCanvas().setTextsize(2);

                if (this.moisture.getValue() >= 600) {
                    this.pump.setValue(1);
                    this.LED.setValue(1);
                    this.OLEDObj.getCanvas().drawString(0,0,("Soil Moisture  Sensor: \n" + (this.moisture.getValue())+"\n The Pump is on"));
                }
                else {
                    this.pump.setValue(0);
                    this.LED.setValue(0);
                    this.OLEDObj.getCanvas().drawString(0,0,("Soil Moisture  Sensor: \n" + (this.moisture.getValue())+"\n The Pump is off"));
                }
                this.OLEDObj.display();
            }
            this.OLEDObj.getCanvas().clear();
            this.OLEDObj.display();
            this.LED.setValue(0);
            this.pump.setValue(0);
            cancel();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}