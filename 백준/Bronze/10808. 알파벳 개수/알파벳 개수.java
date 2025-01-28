import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder sb = new StringBuilder();
        int[] alpha = new int[26];
        for(int i = 0; i < S.length(); i++){
            alpha[S.charAt(i) - 'a']++;
        }
        for(int cnt : alpha){
            sb.append(cnt).append(" ");
        }
        System.out.println(sb);
    }
}