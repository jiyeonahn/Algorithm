import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] cmd = new int[K];
        for(int i = 0; i < K; i++){
            cmd[i] = Integer.parseInt(st.nextToken());
        }

        int[] dice = new int[7];

        for(int i = 0; i < K; i++){
            int c = cmd[i];
            int temp = dice[1];
            if(c == 1){//동
                if(y+1 >= M) continue;
                y++;
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = temp;
            }
            if(c == 2){//서
                if(y-1 < 0) continue;
                y--;
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = temp;
            }
            if(c == 3){//북
                if(x-1 < 0) continue;
                x--;
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = temp;
            }
            if(c == 4){//남
                if(x+1 >= N) continue;
                x++;
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = temp;
            }

            if(map[x][y] == 0){
                map[x][y] = dice[6];
            }else{
                dice[6] = map[x][y];
                map[x][y] = 0;
            }
            System.out.println(dice[1]);
        }
    }
}