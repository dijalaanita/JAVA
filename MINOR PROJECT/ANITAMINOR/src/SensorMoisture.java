

import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.ssd1306.SSD1306;

import java.io.IOException;
public class SensorMoisture {
    public SensorMoisture(SSD1306 myOLED, Pin mySensor, Pin myPump) {
    }

    public static void main(String[] args)
        throws InterruptedException, IOException {
    String myPort = "/dev/cu.usbserial-0001";
    IODevice myGroveBoard = new FirmataDevice(myPort);

    try {
        myGroveBoard.start();
        myGroveBoard.ensureInitializationIsDone();

        var mySensor = myGroveBoard.getPin(15);
        mySensor.setMode(Pin.Mode.ANALOG);

        var myPump = myGroveBoard.getPin(7);
        myPump.setMode(Pin.Mode.OUTPUT);

        if (mySensor.getValue() >= 400) {
            try {
                myPump.setValue(1);
            } catch (Exception ex) {

            }
        } else {
            System.out.println(mySensor.getValue());
        }

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
}
