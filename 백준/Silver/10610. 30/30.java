import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int[] num = new int[N.length()];

        int sum = 0;
        boolean zero_exist = false;

        // 각 자리 수의 합이 3의 배수라면 그 수는 3의 배수다.
        // 일의 자리 수가 0이라면 그 수는 10의 배수다.
        for(int i = 0; i < N.length(); i++){
            num[i] = N.charAt(i) - '0';
            if(num[i] == 0){
                zero_exist = true;
            }
            sum += num[i];
        }

        if(sum % 3 != 0 || !zero_exist){
            System.out.println(-1);
            return;
        }

        Arrays.sort(num);

        StringBuilder sb = new StringBuilder();
        for(int i : num){
            sb.append(i);
        }

        System.out.println(sb.reverse());
    }
}