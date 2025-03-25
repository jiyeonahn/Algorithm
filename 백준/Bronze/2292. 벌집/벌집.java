import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N==1){
            System.out.println(1);
            return;
        }
        int count = 1;
        int start = 2;
        int end = 7;
        while(true){
            if(N >= start && N <= end){
                break;
            }
            start += count*6;
            end += (count+1)*6;

            count++;
        }
        System.out.println(count+1);
    }
}