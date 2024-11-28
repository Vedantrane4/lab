class LongestCommonSubsequence {

    // Function to find the length of the LCS using dynamic programming
    public static int lcsLength(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        // Create a DP table to store the lengths of LCS
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match, add 1 to the diagonal value
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Otherwise, take the maximum of left and top cell
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The length of the LCS will be in the bottom-right cell
        return dp[m][n];
    }

    // Function to print the LCS
    public static String lcsSequence(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        // Create a DP table to store the lengths of LCS
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Backtrack to find the LCS string
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs.append(X.charAt(i - 1)); // Add the character to LCS
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--; // Move up
            } else {
                j--; // Move left
            }
        }

        // Reverse the LCS string as we constructed it backwards
        return lcs.reverse().toString();
    }

    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABA";

        // Calculate the length of the LCS
        int lcsLength = lcsLength(X, Y);
        System.out.println("The length of the LCS is: " + lcsLength);

        // Print the LCS itself
        String lcs = lcsSequence(X, Y);
        System.out.println("The LCS is: " + lcs);
    }
}
