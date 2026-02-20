public class Jobsheet_Q4_Functions {

    static final String[] BRANCHES = {"RoyalGarden 1", "RoyalGarden 2", "RoyalGarden 3", "RoyalGarden 4"};
    static final String[] FLOWERS  = {"Aglonema", "Yam", "Alocasia", "Rose"};
    static final int[]    PRICES   = {75000, 50000, 60000, 10000};

    static final int[][] STOCK = {
        {10,  5, 15,  7},
        { 6, 11,  9, 12},
        { 2, 10, 10,  5},
        { 5,  7, 12,  9}
    };

    /**
     * Calculate the total income of a branch if all flowers are sold.
     * @param branchIndex index of the branch (0-based)
     * @return total income in IDR
     */
    static long calculateIncome(int branchIndex) {
        long total = 0;
        for (int j = 0; j < FLOWERS.length; j++) {
            total += (long) STOCK[branchIndex][j] * PRICES[j];
        }
        return total;
    }

    /**
     * Determine the branch status based on its income.
     * @param income total income of the branch
     * @return "Very Good" or "Need Evaluation"
     */
    static String getStatus(long income) {
        return income > 1_500_000 ? "Very Good" : "Need Evaluation";
    }

    /**
     * Display income and status for all branches.
     */
    static void displayAllBranches() {
        System.out.println("=".repeat(60));
        System.out.println("         RoyalGarden Branch Income Report");
        System.out.println("=".repeat(60));
        System.out.printf("%-16s %-20s %-20s%n", "Branch", "Income (IDR)", "Status");
        System.out.println("-".repeat(60));

        for (int i = 0; i < BRANCHES.length; i++) {
            long   income = calculateIncome(i);
            String status = getStatus(income);
            System.out.printf("%-16s Rp %-17s %-20s%n",
                    BRANCHES[i],
                    String.format("%,d", income),
                    status);
        }
        System.out.println("=".repeat(60));
    }

    /**
     * Display detailed stock breakdown for all branches.
     */
    static void displayStockDetails() {
        System.out.println("\n=".repeat(1) + "=".repeat(59));
        System.out.println("             Stock Detail per Branch");
        System.out.println("=".repeat(60));
        System.out.printf("%-16s %-12s %-8s %-10s %-6s%n",
                "Branch", "Aglonema", "Yam", "Alocasia", "Rose");
        System.out.println("-".repeat(60));

        for (int i = 0; i < BRANCHES.length; i++) {
            System.out.printf("%-16s %-12d %-8d %-10d %-6d%n",
                    BRANCHES[i],
                    STOCK[i][0], STOCK[i][1], STOCK[i][2], STOCK[i][3]);
        }
        System.out.println("=".repeat(60));
    }

    public static void main(String[] args) {
        displayStockDetails();
        System.out.println();
        displayAllBranches();
    }
}