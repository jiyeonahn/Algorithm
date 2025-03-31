import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //3킬로 또는 5킬로
        int a = N/5;
        int answer = -1;
        while(a>=0){
            int m = a*5;
            if((N-m)%3 == 0){
                answer = a+(N-m)/3;
                break;
            }
            a--;
        }
        System.out.println(answer);
    }
}