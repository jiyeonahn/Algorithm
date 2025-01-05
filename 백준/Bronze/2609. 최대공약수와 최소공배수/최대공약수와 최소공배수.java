import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int gcd = gcd(num1, num2);
        System.out.println(gcd);
        System.out.println(num1/gcd * num2/gcd * gcd);
    }
    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
}