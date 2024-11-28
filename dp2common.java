class LongestCommonSubstring {

    // Function to find the length of the longest common substring using dynamic programming
    public static int longestCommonSubstring(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        // Create a DP table to store the length of the longest common substring
        int[][] dp = new int[m + 1][n + 1];

        // Variable to store the length of the longest common substring
        int maxLength = 0;

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match, extend the substring length
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0; // No common substring at this point
                }
            }
        }

        // Return the length of the longest common substring
        return maxLength;
    }

    // Function to find the longest common substring itself
    public static String findLongestCommonSubstring(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        // Create a DP table to store the length of the longest common substring
        int[][] dp = new int[m + 1][n + 1];

        // Variable to store the end index of the longest common substring
        int maxLength = 0;
        int endIndex = -1;

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match, extend the substring length
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i - 1; // Store the end index of the substring
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        // Extract the longest common substring
        return (maxLength == 0) ? "" : X.substring(endIndex - maxLength + 1, endIndex + 1);
    }

    public static void main(String[] args) {
        String X = "ABABC";
        String Y = "BABCA";

        // Find the length of the longest common substring
        int length = longestCommonSubstring(X, Y);
        System.out.println("The length of the longest common substring is: " + length);

        // Find and print the longest common substring itself
        String commonSubstring = findLongestCommonSubstring(X, Y);
        System.out.println("The longest common substring is: " + commonSubstring);
    }
}
