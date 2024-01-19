// Version 3, Updated example (March 2022)
// maven: com.explodingart:jmusic:1.6.4.1
import jm.JMC;
import jm.music.data.*;
import jm.util.Play;
import jm.constants.*; // Pitches.E0, RhythmValues.TN, etc.
// JMusic: Make it go Bing! https://explodingart.com/jmusic/jmtutorial/x34.html#bing
// Harmonica mapping: http://harmonicatunes.com/harmonica-notes/
// Harmonica happy birthday : https://www.harmonica.com/happy-birthday-by-publicdomain-1665.html
public final class Bing implements JMC
{
    public static void main(String[] args)
    {
        Play.midi(new Note(Pitches.D4, RhythmValues.TN));
        Play.midi(new Note(Pitches.D4, RhythmValues.TN));
        Play.midi(new Note(Pitches.E4, RhythmValues.TN));
        Play.midi(new Note(Pitches.F4, RhythmValues.TN));
        Play.midi(new Note(Pitches.E4, RhythmValues.TN));
        Play.midi(new Note(Pitches.F4, RhythmValues.TN));
        Play.midi(new Note(Pitches.E4, RhythmValues.TN));
        Play.midi(new Note(Pitches.F4, RhythmValues.TN));
        Play.midi(new Note(Pitches.F4, RhythmValues.TN));
        Play.midi(new Note(Pitches.D4, RhythmValues.TN));
        Play.midi(new Note(Pitches.E4, RhythmValues.TN));
        Play.midi(new Note(Pitches.E4, RhythmValues.TN));
        Play.midi(new Note(Pitches.E4, RhythmValues.TN));
        Play.midi(new Note(Pitches.E4, RhythmValues.TN));
        Play.midi(new Note(Pitches.E4, RhythmValues.TN));
        Play.midi(new Note(Pitches.E4, RhythmValues.TN));
        Play.midi(new Note(Pitches.E4, RhythmValues.TN));
        Play.midi(new Note(Pitches.F4, RhythmValues.TN));
        Play.midi(new Note(Pitches.D4, RhythmValues.TN));
        Play.midi(new Note(Pitches.D4, RhythmValues.TN*0.5));
        // Alternatively:
        // Play.midi(new Note(JMC.G3, 0.75*JMC.TN));
    }
}