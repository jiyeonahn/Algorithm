import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[len1][len2];

        for (int i = 0; i < len1; i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                dp[i][0] = 1;
                continue;
            }
            if (i > 0) {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 0; i < len2; i++) {
            if (str2.charAt(i) == str1.charAt(0)) {
                dp[0][i] = 1;
                continue;
            }
            if (i > 0) {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.print(dp[len1-1][len2-1]);

    }
}