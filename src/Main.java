import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int afterDays = 0;

        System.out.println("Day after x days calculator");


        while (true) {
            int dayNumber = -1;
            while (dayNumber == -1) {
                System.out.print("Enter the day: ");
                String day = in.nextLine();
                String process = processDay(day);
                dayNumber = dayToNum(process);
            }
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter the number of days passed: ");
                if (in.hasNextInt()) {
                    afterDays = in.nextInt();
                    validInput = true;
                } else {
                    System.out.println("Invalid input! Please enter a valid number.");
                    in.next();
                }
            }
            in.nextLine();
            int newDay = getDay(dayNumber, afterDays);
            String result = numToDay(newDay);
            String dayName = numToDay(dayNumber);
            System.out.println("The day after " + afterDays + " days from " + dayName + " is " + result);
            break;
        }
        in.close();
    }

    private static String numToDay(int newDay){
        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        return days[newDay % 7];
    }

    private static int getDay(int day, int afterDays) {
        return (day + afterDays) % 7;
    }
    private static int dayToNum(String process) {
        return switch (process) {
            case "Sun" -> 0;
            case "Mon" -> 1;
            case "Tue" -> 2;
            case "Wed" -> 3;
            case "Thu" -> 4;
            case "Fri" -> 5;
            case "Sat" -> 6;
            default -> {
                System.out.println("Invalid day! Please enter a valid day.");
                yield -1;
            }
        };
    }

    private static String processDay(String day) {
        String trimmed = day.trim();

        String truncated = trimmed.length () > 3 ? trimmed.substring(0,3) : trimmed;
        if (truncated.isEmpty()){
            System.out.println("Invalid day! Please enter a valid day.");
            return "";
        }

        return Character.toUpperCase(truncated.charAt(0)) + truncated.substring(1).toLowerCase();

    }


}