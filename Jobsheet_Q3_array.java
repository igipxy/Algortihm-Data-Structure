import java.util.Scanner;

public class Jobsheet_Q3_array {

    // Convert letter grade to equivalent value (Nilai Setara)
    static double letterToSetara(String grade) {
        switch (grade.toUpperCase()) {
            case "A":  return 4.0;
            case "B+": return 3.5;
            case "B":  return 3.0;
            case "C+": return 2.5;
            case "C":  return 2.0;
            case "D":  return 1.0;
            case "E":  return 0.0;
            default:   return -1; // invalid
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("======================");
        System.out.println("Program Menghitung IP Semester");
        System.out.println("======================");

        System.out.print("Masukkan jumlah mata kuliah: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] namaMK     = new String[n];
        int[]    sks        = new int[n];
        String[] nilaiHuruf = new String[n];
        double[] nilaiSetara = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nama MK ke-" + (i + 1) + "  : ");
            namaMK[i] = sc.nextLine();

            System.out.print("Bobot SKS       : ");
            sks[i] = sc.nextInt();

            System.out.print("Nilai Huruf     : ");
            nilaiHuruf[i] = sc.next();
            sc.nextLine();

            nilaiSetara[i] = letterToSetara(nilaiHuruf[i]);
            if (nilaiSetara[i] < 0) {
                System.out.println("Nilai huruf tidak valid! Masukkan ulang.");
                i--; // retry this course
                continue;
            }
            System.out.println();
        }

        // Calculate IP Semester
        double totalNilaiBobot = 0;
        int    totalSKS        = 0;

        for (int i = 0; i < n; i++) {
            totalNilaiBobot += nilaiSetara[i] * sks[i];
            totalSKS        += sks[i];
        }

        double ipSemester = totalNilaiBobot / totalSKS;

        // Display result table
        System.out.println("\n======================");
        System.out.println("Hasil Konversi Nilai");
        System.out.println("======================");
        System.out.printf("%-35s %-12s %-12s %-10s%n",
                "MK", "Nilai Angka", "Nilai Huruf", "Bobot Nilai");
        System.out.println("-".repeat(72));

        for (int i = 0; i < n; i++) {
            System.out.printf("%-35s %-12.2f %-12s %-10.2f%n",
                    namaMK[i], nilaiSetara[i] * 25, nilaiHuruf[i], nilaiSetara[i]);
        }

        System.out.println("======================");
        System.out.printf("IP Semester : %.2f%n", ipSemester);
        System.out.println("======================");

        sc.close();
    }
}