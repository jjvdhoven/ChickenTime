import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class chknClockMain {

    public static void deltaNonRandom(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String str = sdf.format(new Date());

        System.out.printf("current system time is \n\n" + str);

        Scanner inputTime = new Scanner(System.in);
        System.out.println("Enter a time in the 24 clock format ");

        String userInput = inputTime.nextLine();
        System.out.println("\nthe given input time is: " + userInput);

        LocalTime timeIn = LocalTime.parse(str, DateTimeFormatter.ofPattern("H:m"));
        LocalTime timeOut = LocalTime.parse(userInput, DateTimeFormatter.ofPattern("H:m"));
        long dif = ChronoUnit.MINUTES.between(timeIn, timeOut);
        if (dif < 0)
            dif += 24 * 60;
        long sumHour = dif / 60;
        long sumMinute = dif % 60;

        System.out.println("\nDifference between system time and input: " + sumHour + ":"+ sumMinute + "\n");
    }

    public static void deltaRandom() {
        Random rand = new Random();

        //calculate 4 digits for hh:mm
        int hxxx = rand.nextInt(3);
        int xhxx = rand.nextInt(10);
        int xxhx = rand.nextInt(6);
        int xxxh = rand.nextInt(10);

        //check if 2nd digit is above 4 to avoid 2500 hours
        if (hxxx == 2){
            while (xhxx > 3){
                xhxx = rand.nextInt(10);
            }
        }

        //convert integers to strings
        String strhxxx = Integer.toString(hxxx);
        String strxhxx = Integer.toString(xhxx);
        String strxxhx = Integer.toString(xxhx);
        String strxxxh = Integer.toString(xxxh);

        //add strings into one string
        String str = strhxxx + strxhxx + ":" + strxxhx + strxxxh;

        //print random 4 digits as system time
        System.out.printf("current system time is " + str + "\n");

        //make scanner object for input
        Scanner inputTime = new Scanner(System.in);
        System.out.println("Enter a time in the 24 hour clock format: ");

        //catch user input
        String userInput = inputTime.nextLine();
        System.out.println("\nthe given input time is: " + userInput);

        //calculate time delta
        LocalTime timeIn = LocalTime.parse(str, DateTimeFormatter.ofPattern("H:m"));
        LocalTime timeOut = LocalTime.parse(userInput, DateTimeFormatter.ofPattern("H:m"));
        long dif = ChronoUnit.MINUTES.between(timeIn, timeOut);
        if (dif < 0)
            dif += 24 * 60;
        long sumHour = dif / 60;
        long sumMinute = dif % 60;

        //add total delta into one Integer
        int totalHoursInt = (int)sumHour;
        int totalMinutesInt = (int)sumMinute;
        int totalSeconds = ((totalHoursInt * 60) + totalMinutesInt) * 60;

        //print difference
        System.out.println("Difference between system time and input is: " + sumHour + " hours and " + sumMinute + " minutes");

        //calculate chicken distance
        float chickenSpeed = 4.0233611111F; //chicken metres / second
        float chickenDistance = chickenSpeed * totalSeconds;
        System.out.println("A chicken would have ran " + chickenDistance + " metres by then.");

    }

    public static void main(String[] args) {
        //deltaNonRandom();
        deltaRandom();
    }
}
