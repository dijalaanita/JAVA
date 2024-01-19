package Task2;
import jm.JMC;
import jm.music.data.*;
import jm.util.*;
public class RandomMelody {
        private Score scores;
        private Part snared;
        private Phrase phr;
        private double[] intervals;

        public RandomMelody(String title)
        {
            scores = new Score(title);
            snared = new Part("Snare", 0, 9);
            phr = new Phrase(0.0);
            scores.add(snared);
            snared.add(phr);
        }
        public void generateRandomNotes(int max)
        {
            intervals = new double[24];

            for (int i = 0; i < 24; i++)
            {
                double rv = Math.random() * max;
                intervals[i] = rv;
                phr.add(new Note(38, rv));
            }
        }
        public void addASong(int instrument,int[] pitchArray)
        {
            if (pitchArray.length != 24)
                return;
            Part p2 = new Part(instrument);
            Phrase newP = new Phrase(0.0);
            newP.addNoteList(pitchArray, intervals);
            p2.add(newP);
            scores.add(p2);
        }

        public void play ( )
        {
            Play.midi(scores);
        }
        public void save ( )
        {
            Write.midi (scores, scores.getTitle() + ".mid");
        }
        public void view ( )
        {
            View.sketch(scores);
        }
        public void clear ( )
        {
            scores = new Score(scores.getTitle());
            snared = new Part("Snared", 0, 9);
            phr = new Phrase(0.0);
            scores.add(snared);
            snared.add(phr);
        }
    }

