import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int[] alpha1 = new int[26];
        int[] alpha2 = new int[26];

        for(int i = 0; i < str1.length(); i++){
            alpha1[str1.charAt(i)-'a']++;
        }

        for(int i = 0; i < str2.length(); i++){
            alpha2[str2.charAt(i)-'a']++;
        }

        int count = 0;
        for(int i = 0; i < 26; i++){
            count += Math.abs(alpha1[i] - alpha2[i]);
        }

        System.out.println(count);
    }
}