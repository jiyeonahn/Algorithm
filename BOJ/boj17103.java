import java.io.*;

public class boj17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int max = 1000000;
        boolean[] arr = new boolean[max+1];//false가 default, false => 소수

        arr[0] = true;//true => 소수 아님
        arr[1] = true;

        for(int i = 2; i <= Math.sqrt(max); i++){
            if(arr[i]) continue;
            for(int j = i*i; j <= max; j+=i){
                arr[j] = true;
            }
        }

        for(int i = 0; i < N; i++){
            int cnt = 0;
            int num = Integer.parseInt(br.readLine());
            for(int j = 2; j <= num/2; j++){
                if(!arr[j] && !arr[num-j])
                    cnt++;
            }
            bw.write(cnt+"\n");
        }

        bw.flush();
        bw.close();
    }
}