import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;

        int[] num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int index = 0;
        while(st.hasMoreTokens()){
            num[index] = Integer.parseInt(st.nextToken());
            index++;
        }
        Arrays.sort(num);

        for(int i = 0; i < num.length; i++){
            if(i != 0)
                num[i] += num[i-1];
            sum += num[i];
        }

        System.out.println(sum);
    }
}
