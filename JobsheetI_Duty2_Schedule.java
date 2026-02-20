import java.util.Scanner;

public class JobsheetI_Duty2_Schedule {

    static Scanner sc = new Scanner(System.in);

    static String[][] inputSchedule(int n) {
        String[][] schedule = new String[n][4];
        System.out.println("\n--- Input Lecture Schedule ---");

        for (int i = 0; i < n; i++) {
            System.out.println("\nSchedule #" + (i + 1));
            System.out.print("  Course Name   : ");
            schedule[i][0] = sc.nextLine();
            System.out.print("  Room          : ");
            schedule[i][1] = sc.nextLine();
            System.out.print("  Lecture Day   : ");
            schedule[i][2] = sc.nextLine();
            System.out.print("  Lecture Hours : ");
            schedule[i][3] = sc.nextLine();
        }
        return schedule;
    }

    static void displayAll(String[][] schedule) {
        System.out.println("\n" + "=".repeat(85));
        System.out.println("                         FULL LECTURE SCHEDULE");
        System.out.println("=".repeat(85));
        System.out.printf("%-3s %-28s %-18s %-12s %-14s%n",
                "No", "Course Name", "Room", "Day", "Hours");
        System.out.println("-".repeat(85));

        for (int i = 0; i < schedule.length; i++) {
            System.out.printf("%-3d %-28s %-18s %-12s %-14s%n",
                    (i + 1),
                    schedule[i][0],
                    schedule[i][1],
                    schedule[i][2],
                    schedule[i][3]);
        }
        System.out.println("=".repeat(85));
    }


    static void searchByDay(String[][] schedule, String day) {
        System.out.println("\n" + "=".repeat(85));
        System.out.println("  Schedules on: " + day);
        System.out.println("=".repeat(85));
        System.out.printf("%-3s %-28s %-18s %-12s %-14s%n",
                "No", "Course Name", "Room", "Day", "Hours");
        System.out.println("-".repeat(85));

        int count = 0;
        for (int i = 0; i < schedule.length; i++) {
            if (schedule[i][2].equalsIgnoreCase(day)) {
                count++;
                System.out.printf("%-3d %-28s %-18s %-12s %-14s%n",
                        count,
                        schedule[i][0],
                        schedule[i][1],
                        schedule[i][2],
                        schedule[i][3]);
            }
        }

        if (count == 0) {
            System.out.println("  No schedule found for day: " + day);
        }
        System.out.println("=".repeat(85));
    }


    static void searchByCourse(String[][] schedule, String courseName) {
        System.out.println("\n" + "=".repeat(85));
        System.out.println("  Search result for course: \"" + courseName + "\"");
        System.out.println("=".repeat(85));
        System.out.printf("%-3s %-28s %-18s %-12s %-14s%n",
                "No", "Course Name", "Room", "Day", "Hours");
        System.out.println("-".repeat(85));

        int count = 0;
        for (int i = 0; i < schedule.length; i++) {
            if (schedule[i][0].toLowerCase().contains(courseName.toLowerCase())) {
                count++;
                System.out.printf("%-3d %-28s %-18s %-12s %-14s%n",
                        count,
                        schedule[i][0],
                        schedule[i][1],
                        schedule[i][2],
                        schedule[i][3]);
            }
        }

        if (count == 0) {
            System.out.println("  Course \"" + courseName + "\" not found.");
        }
        System.out.println("=".repeat(85));
    }


    public static void main(String[] args) {
        System.out.println("=".repeat(50));
        System.out.println("   Student Lecture Schedule Management");
        System.out.println("=".repeat(50));

        System.out.print("Enter number of lecture schedules (n): ");
        int n = Integer.parseInt(sc.nextLine().trim());

        String[][] schedule = inputSchedule(n);

        int choice;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Display all schedules");
            System.out.println("2. Search by day");
            System.out.println("3. Search by course name");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1:
                    displayAll(schedule);
                    break;
                case 2:
                    System.out.print("Enter day (e.g. Monday): ");
                    String day = sc.nextLine();
                    searchByDay(schedule, day);
                    break;
                case 3:
                    System.out.print("Enter course name (or keyword): ");
                    String courseName = sc.nextLine();
                    searchByCourse(schedule, courseName);
                    break;
                case 0:
                    System.out.println("Program ended.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}