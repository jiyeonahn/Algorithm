import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int answer = 0;
        while(true){
            try{
                st.nextToken();
                answer++;
            }catch(Exception e){
                break;
            }
        }
        
        System.out.println(answer);
        
    }
}