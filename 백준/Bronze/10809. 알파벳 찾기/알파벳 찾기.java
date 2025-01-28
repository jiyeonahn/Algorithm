import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[] alpha = new int[26];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            alpha[i] = S.indexOf((char) ('a' + i));
        }
        for(int al : alpha){
            sb.append(al).append(" ");
        }
        System.out.println(sb);
    }
}