import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int m = 0;
        for(int i = 1; i < N; i++){
            int sum = i;
            int n = i;
            
            while(n > 0){
                sum += n % 10;
                n = n / 10;
            }

            if(sum == N) {
                m = i;
                break;
            }
        }
        System.out.println(m);
    }
}