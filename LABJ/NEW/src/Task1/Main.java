package Task1;

import jm.JMC;
import jm.music.data.*;
import jm.util.*;

public class Main {
    public static void main(String[] args) {
        Note myNote = new Note(50, 1);

        Play myPlay = new Play();

        myPlay.midi(myNote);
    }
}