import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//shift + tab : 왼쪽으로 탭 이동
public class boj2810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String input = br.readLine();

        char[] seat = input.toCharArray();
        int sCount = 0;
        int lCount = 0;

        for(int i = 0; i < N; i++){
            if(seat[i] == 'S')
                sCount++;
            else
                lCount++;
        }

        System.out.println(Math.min(N, sCount + lCount/2 + 1));

    }
}
