import java.io.*;

public class boj10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(factorial(N));
    }
    public static int factorial(int N){
        if(N <= 1) return 1;
        return N*factorial(N-1);
    }
}