import org.firmata4j.firmata.*;
import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import java.io.IOException;
import org.firmata4j.ssd1306.SSD1306;
import org.firmata4j.I2CDevice;

import java.util.Timer;

public class WaterPump {

    public static void main(String[] args)
            throws InterruptedException, IOException{
        String myPort = "/dev/cu.usbserial-0001";
        IODevice myGroveBoard = new FirmataDevice(myPort);

        Timer timerTask = new Timer();

        try{
            myGroveBoard.start();
            myGroveBoard.ensureInitializationIsDone();

            I2CDevice i2CDevice = myGroveBoard.getI2CDevice((byte)0x3C);
            SSD1306 myOLED = new SSD1306(i2CDevice, SSD1306.Size.SSD1306_128_64);
            myOLED.init();

            var mySensor = myGroveBoard.getPin(15);
            mySensor.setMode(Pin.Mode.ANALOG);

            var myPump = myGroveBoard.getPin(7);
            myPump.setMode(Pin.Mode.OUTPUT);

            var moistTask = new Sensor(myOLED, mySensor, myPump);

            timerTask.schedule(moistTask, 0, 100);

        }catch (Exception ex){
            ex.printStackTrace();
        } finally {
            timerTask.cancel();
        }
    }
}
