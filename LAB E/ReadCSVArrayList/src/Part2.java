import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class Part2 {
    public static void main(String[] args) {
        try {
            // Step 1. Name the file and create a File object
            var theAirQualityFile = new File("Part2_CO2_DataLog_Modified_short.csv");

            // Step 2. Read all lines in the File object
            var fixedLengthList = Files.readAllLines(theAirQualityFile.toPath());

            // Step 3: copy fixed list to an ArrayList
            ArrayList<String> listOfString = new ArrayList<String>(fixedLengthList);

            // Step 4. Create numeric variables to hold totals, increments, etc.
            int total = 0; // holds the total value
            double increment = 0.5; // holds the increment value

            // Step 5. Loop through all rows of the ArrayList. How many times?
            // Apply the .size() method on the ArrayList.
            // Double.parseDouble() or Integer.parseInt() as necessary.

            for (String row : listOfString) {
                // split the row into individual values
                String[] splitRow = row.split(",");

                // convert the second value to a double and add it to the total
                int value = Integer.parseInt(splitRow[3]);
                total += value;
            }

// calculate the average and print it to the screen
            int average = total / listOfString.size();
            System.out.println("The average value is: " + average);


            // Calculate the average & print to screen.
        } catch (IOException ex) {
            System.out.println("File reading exception");
        }
    }
}
