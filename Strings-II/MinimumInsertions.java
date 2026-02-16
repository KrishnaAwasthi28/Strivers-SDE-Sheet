class MinimumInsertions {
    public int minInsertions(String s) {
        StringBuilder rev = new StringBuilder(s);
        char[] str1 = s.toCharArray();
        char[] str2 = rev.reverse().toString().toCharArray();
        int m = str1.length;
        int n = str2.length;
        
        // dp[i][j] stores the LCS of s and reversed s
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Minimum insertions = total length - LPS length
        return m - dp[m][n];
    }
}
