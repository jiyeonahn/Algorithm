import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] alpha = new int[26];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                alpha[str.charAt(j)-'A'] += Math.pow(10, str.length()-j-1);
            }
        }

        Arrays.sort(alpha);

        int answer = 0;
        int n = 9;
        for(int i = 25; i >= 0; i--){
            answer += alpha[i] * n;
            n--;
        }

        System.out.println(answer);
    }
}