import java.io.*;

public class boj9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[11];

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());

                arr[1] = 1;
                arr[2] = 2;
                arr[3] = 4;

                for(int j = 4; j <= num; j++){
                    arr[j] = arr[j-1] + arr[j-2] + arr[j-3];
                }
                bw.write(arr[num]+"\n");
        }
        bw.flush();
        bw.close();
    }
}