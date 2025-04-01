import java.util.*;
import java.io.*;
class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] fibo = new long[n+1];
        fibo[1] = 1;
        if(n > 1) fibo[2] = 1;
        if(n > 2) fibo[3] = 1;

        for(int i = 4; i <= n; i++){
            fibo[i] = fibo[i-1] + fibo[i-3];
        }

        System.out.println(fibo[n]);
    }
}