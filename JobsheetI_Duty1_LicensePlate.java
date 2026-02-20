import java.util.Scanner;

public class JobsheetI_Duty1_LicensePlate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1D array: license plate codes
        char[] CODE = {'A', 'B', 'D', 'E', 'F', 'G', 'H', 'L', 'N', 'T'};

        // 2D array: city names (each name max 12 chars, stored as char array)
        char[][] KOTA = {
            "BANTEN".toCharArray(),
            "JAKARTA".toCharArray(),
            "BANDUNG".toCharArray(),
            "CIREBON".toCharArray(),
            "BOGOR".toCharArray(),
            "PEKALONGAN".toCharArray(),
            "SEMARANG".toCharArray(),
            "SURABAYA".toCharArray(),
            "MALANG".toCharArray(),
            "TEGAL".toCharArray()
        };

        // Display all available codes
        System.out.println("=".repeat(35));
        System.out.println("  License Plate Code Lookup Program");
        System.out.println("=".repeat(35));
        System.out.printf("%-8s %-20s%n", "Code", "City");
        System.out.println("-".repeat(35));
        for (int i = 0; i < CODE.length; i++) {
            System.out.printf("  %-6c %-20s%n", CODE[i], new String(KOTA[i]));
        }
        System.out.println("=".repeat(35));

        // User input
        System.out.print("\nMasukkan kode plat (huruf besar): ");
        char input = sc.next().toUpperCase().charAt(0);

        // Search
        boolean found = false;
        for (int i = 0; i < CODE.length; i++) {
            if (CODE[i] == input) {
                System.out.println("Kode  : " + CODE[i]);
                System.out.println("Kota  : " + new String(KOTA[i]));
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Kode plat '" + input + "' tidak ditemukan.");
        }

        sc.close();
    }
}