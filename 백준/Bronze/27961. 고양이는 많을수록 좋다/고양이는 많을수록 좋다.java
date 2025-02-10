import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long num = 1;
        int answer = 1;
        while(N-num > num){
            num += num;
            answer++;
        }
        if(N <= 1){
            System.out.println(N);
        }else{
            System.out.println(answer+1);
        }
    }
}