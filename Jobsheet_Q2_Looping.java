import java.util.Scanner;

public class Jobsheet_Q2_Looping {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan NIM: ");
        String nim = sc.next();

        // Get last 2 digits of NIM
        int n = Integer.parseInt(nim.substring(nim.length() - 2));

        // If n < 10, add 10
        if (n < 10) {
            n += 10;
        }

        System.out.println("n = " + n);
        System.out.print("Output: ");

        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            // Skip 10 and 15
            if (i == 10 || i == 15) {
                continue;
            }

            if (i % 3 == 0) {
                output.append("#");
            } else if (i % 2 == 0) {
                output.append(i);
            } else {
                output.append("*");
            }
        }

        System.out.println(output.toString());
        sc.close();
    }
}