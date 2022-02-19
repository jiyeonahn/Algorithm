import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj14226_x {//이모티콘
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());

        int[] arr = new int[3];
        int[] time = new int[10001];

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while(!q.isEmpty()){
            int n = q.poll();

            if(n == S) {
                System.out.println(time[n]);
                break;
            }

            if(n == 0) continue;

            //복사하기
            arr[0] = n;

            //붙여넣기
            arr[1] = n*2;
            if(time[arr[1]] != 0)
                time[arr[1]] = Math.min(time[arr[1]],time[n] + 1);
            else
                time[arr[1]] = time[n] + 1;
            q.add(arr[1]);

            //삭제하기
            arr[2] = n-1;
            if(time[arr[2]] != 0)
                time[arr[2]] = Math.min(time[arr[2]],time[n] + 1);
            else
                time[arr[2]] = time[n] + 1;
            q.add(arr[2]);
        }

    }

}