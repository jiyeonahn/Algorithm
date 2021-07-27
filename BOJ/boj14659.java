import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//shift + tab : 왼쪽으로 탭 이동
public class boj14659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int num = Integer.parseInt(st.nextToken());
        int count = 0;
        int max = 0;

        while(st.hasMoreTokens()){
            int next = Integer.parseInt(st.nextToken());
            if(num > next) count++;
            else{
                num = next;
                max = Math.max(count,max);
                count = 0;
            }
        }
        System.out.println(Math.max(count,max));
    }
}
