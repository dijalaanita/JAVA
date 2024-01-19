package Task1;

import jm.music.data.*;
import jm.JMC;
import jm.util.*;
import static jm.constants.Durations.SQ;
public class Main
{
    public static void main(String[] args)
    {
        Note myNote = new Note();
        Phrase myPhrase = new Phrase();
        Phrase anotherPhrase = new Phrase();
        Part myPart = new Part();
        Part anotherPart = new Part();
        Score myScore = new Score();

        for(int i = 0; i< 10;i++) {
           myPhrase.add(new Note((int)(30+Math.random()*30),(int)(Math.random()*10)));


        }
        for(int i = 0; i<10;i++)

        {
            myPhrase.add(new Note((int) ( 30 + Math.random() * 30 ), (int) ( Math.random() * 10 )));

        }
        myPart.addPhrase(myPhrase);
        anotherPart.addPhrase(anotherPhrase);

        myScore.addPart(myPart);
        myScore.addPart(anotherPart);
        View.notate(myScore);
        Play.midi(myScore);
        Write.midi(myScore,"myScore.midi");
    }
}