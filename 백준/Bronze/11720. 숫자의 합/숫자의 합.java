import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] number = br.readLine().split("");
        int sum=0;
        for(String num : number){
            sum += Integer.parseInt(num);
        }
        System.out.println(sum);
    }
}