import java.io.FileInputStream;
import java.io.*;

public class MyTextFileReaderr
{
    public static void main(String[] args)
            throws IOException
    {
        int myData;

        // open the file here.
        FileInputStream myFileObject = new FileInputStream("Part1TextFile.txt");

        // loop through the data in the while below.
        while((myData = myFileObject.read()) != -1)
        {
            // print a character here.
            System.out.print((char) myData);
        }

        // close the file here.
        myFileObject.close();
    }
}
