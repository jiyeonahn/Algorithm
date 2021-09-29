import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] isNotPrime = new boolean[10000000];
        ArrayList<Integer> num = new ArrayList<>();

        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for(int i = 2; i < Math.sqrt(10000000); i++){
            if(!isNotPrime[i]) continue;
            for(int j = i*i; j < 10000000; j += i)
                isNotPrime[i] = true;
        }

        int n = 2;
        while(N != 1){
            if(isNotPrime[n]) {
                n++;
                continue;
            }
            if(N % n == 0) {
                num.add(n);
                N /= n;
            }
            else n++;
        }

        Collections.sort(num);
        for(int i: num)
            System.out.println(i);

    }
}
