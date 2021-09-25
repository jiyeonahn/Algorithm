import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        if(num == 1 || num == 0) sb.append(num);
        else{
            while(true){
                if(num == -1){
                    sb.append(1).append(1); break;
                }
                else if(num == -2){
                    sb.append(0).append(1); break;
                }
                sb.append(Math.abs(num) % 2);
                if(num < 0 && Math.abs(num) % 2 != 0) num = (num / -2) + 1;
                else num = (num / -2);
            }
        }
        System.out.println(sb.reverse().toString());
    }
}
