import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 1;
        int end = 1;
        while(true){
            if(N <= end){
                break;
            }
            end += count*6;

            count++;
        }
        System.out.println(count);
    }
}