import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        String binaryString = Integer.toBinaryString(K+1);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < binaryString.length(); i++){
            sb.append(binaryString.charAt(i) == '0' ? '4' : '7');
        }

        System.out.println(sb);
    }
}