import org.firmata4j.I2CDevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.ssd1306.SSD1306;
import java.util.Timer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException
    {
        var arduino = new FirmataDevice("COM3");
        arduino.start();
        arduino.ensureInitializationIsDone();

        var sensor = arduino.getPin(15);

        var pump = arduino.getPin(2);
        pump.setMode(Pin.Mode.OUTPUT);

        var LED = arduino.getPin(4);
        LED.setMode(Pin.Mode.OUTPUT);

        var button = arduino.getPin(6);
        button.setMode(Pin.Mode.INPUT);

        I2CDevice i2cObject = arduino.getI2CDevice((byte) 0x3C);
        SSD1306 OLED = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64);
        OLED.init();

        Timer timer = new Timer();
        var task = new sensorGraph (timer, LED, sensor, button);
        timer.schedule(task,0,500);
    }
}