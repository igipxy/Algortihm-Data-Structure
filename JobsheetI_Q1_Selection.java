import java.util.Scanner;

public class JobsheetI_Q1_Selection {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("======================");
        System.out.println("Program Menghitung Nilai Akhir");
        System.out.println("======================");

        System.out.print("Masukkan Nilai Tugas  : ");
        double tugas = sc.nextDouble();

        System.out.print("Masukkan Nilai Kuis   : ");
        double kuis = sc.nextDouble();

        System.out.print("Masukkan Nilai UTS    : ");
        double uts = sc.nextDouble();

        System.out.print("Masukkan Nilai UAS    : ");
        double uas = sc.nextDouble();

        System.out.println("======================");

        // Validate all inputs are in range 0-100
        if (tugas < 0 || tugas > 100 ||
            kuis  < 0 || kuis  > 100 ||
            uts   < 0 || uts   > 100 ||
            uas   < 0 || uas   > 100) {

            System.out.println("======================");
            System.out.println("nilai tidak valid");
            System.out.println("======================");
            sc.close();
            return;
        }

        // Calculate final score
        double nilaiAkhir = (0.20 * tugas) + (0.20 * kuis) + (0.30 * uts) + (0.30 * uas);

        // Determine letter grade
        String nilaiHuruf;
        String kualifikasi;

        if (nilaiAkhir > 80 && nilaiAkhir <= 100) {
            nilaiHuruf  = "A";
            kualifikasi = "Sangat Baik";
        } else if (nilaiAkhir > 73 && nilaiAkhir <= 80) {
            nilaiHuruf  = "B+";
            kualifikasi = "Lebih dari Baik";
        } else if (nilaiAkhir > 65 && nilaiAkhir <= 73) {
            nilaiHuruf  = "B";
            kualifikasi = "Baik";
        } else if (nilaiAkhir > 60 && nilaiAkhir <= 65) {
            nilaiHuruf  = "C+";
            kualifikasi = "Lebih dari Cukup";
        } else if (nilaiAkhir > 50 && nilaiAkhir <= 60) {
            nilaiHuruf  = "C";
            kualifikasi = "Cukup";
        } else if (nilaiAkhir > 39 && nilaiAkhir <= 50) {
            nilaiHuruf  = "D";
            kualifikasi = "Kurang";
        } else {
            nilaiHuruf  = "E";
            kualifikasi = "Gagal";
        }

        // Determine pass/not pass
        boolean lulus = nilaiHuruf.equals("A")  || nilaiHuruf.equals("B+") ||
                        nilaiHuruf.equals("B")  || nilaiHuruf.equals("C+") ||
                        nilaiHuruf.equals("C");

        // Display results
        System.out.println("======================");
        System.out.printf("Nilai Akhir   : %.1f%n", nilaiAkhir);
        System.out.println("Nilai Huruf   : " + nilaiHuruf);
        System.out.println("Kualifikasi   : " + kualifikasi);
        System.out.println("======================");
        if (lulus) {
            System.out.println("SELAMAT ANDA LULUS");
        } else {
            System.out.println("ANDA TIDAK LULUS");
        }
        System.out.println("======================");

        sc.close();
    }
}