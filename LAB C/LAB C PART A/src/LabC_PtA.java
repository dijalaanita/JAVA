import java.util.Scanner;
public class LabC_PtA {
    public static void main(String[] args)
    {
        var ScanObject = new Scanner(System.in);
        ScanObject.useRadix(2);
        System.out.print("Enter a binary number");
        var counter = 0;
        while (ScanObject.hasNext())
        {

            var IntegerFromUser = ScanObject.nextInt();
            counter = counter + IntegerFromUser ;
            System.out.println("Running Sum: " + Integer.toBinaryString(counter) );
            System.out.println("Enter a binary number");
        }




    }


}