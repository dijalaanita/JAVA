package Task2;
import Task2.RandomMelody;
import jm.JMC;
import jm.music.data.*;
import jm.util.*;

public class Main {

    public static void main(String[] args)
    {
        RandomMelody rm = new RandomMelody("Anita"); //Pass your name
        rm.generateRandomNotes(2);
        //include 24 pitches of a song you would like to play
        int[] pitchArray = {JMC.D4, JMC.D4, JMC.E4, JMC.F4, JMC.E4, JMC.F4, JMC.E4, JMC.F4,
                JMC.F4, JMC.D4, JMC.E4, JMC.E4, JMC.E4, JMC.E4, JMC.E4, JMC.E4,
                JMC.E4, JMC.D4, JMC.D4, JMC.D4, JMC.D4, JMC.E4, JMC.F4, JMC.E4 };

        rm.addASong(JMC.PIANO,pitchArray);
        rm.play();
        rm.save();
        rm.clear();
        rm.play();
};
}
