import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        int answer = 0;
        for(int i = 0; i < N.length(); i++){
            if(N.charAt(i)-'0' > 9){
                answer += Math.pow(B, N.length()-i-1) * (N.charAt(i)-'A' + 10);
            }else{
                answer += Math.pow(B, N.length()-i-1) * (N.charAt(i)-'0');
            }
        }
        System.out.println(answer);
    }
}