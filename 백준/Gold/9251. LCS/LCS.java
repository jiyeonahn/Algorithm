import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] dp = new int[str1.length()][str2.length()];

        int max = 0;
        for(int i = 0; i < str2.length(); i++){
            if(str1.charAt(0) == str2.charAt(i)){
                max = 1;
            }
            dp[0][i] = max;
        }

        max = 0;
        for(int i = 0; i < str1.length(); i++){
            if(str2.charAt(0) == str1.charAt(i)){
                max = 1;
            }
            dp[i][0] = max;
        }

        for(int i = 1; i < str1.length(); i++){
            for(int j = 1; j < str2.length(); j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[str1.length()-1][str2.length()-1]);

    }
}