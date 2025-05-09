import java.io.*;

class Main {
    static int cnt;
    static int[] f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        fib(n);
        System.out.println(cnt + " " + (n-2));
    }

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            cnt++;
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

}