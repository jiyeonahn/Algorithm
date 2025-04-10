import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int len = N*2;

        int[] belt = new int[len];
        boolean[] isRobot = new boolean[len];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < len; i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int level = 0;
        int count = 0;
        while(count < K){
            level++;
            //벨트 회전
            int tempBelt = belt[len-1];
            for(int i = len-1; i >= 1; i--){
                belt[i] = belt[i-1];
            }
            belt[0] = tempBelt;

            //로봇 회전
            boolean tempRobot = isRobot[len-1];
            for(int i = len-1; i >= 1; i--){
                isRobot[i] = isRobot[i-1];
            }
            isRobot[0] = tempRobot;

            //언제든지 로봇이 내리는 위치에 도달하면 그 즉시 내림
            isRobot[N-1] = false;

            //로봇 이동 (현재 위치에 로봇이 있는 경우에만)
            for(int i = N-2; i >= 0; i--){
                if(!isRobot[i]) continue;
                if(belt[i+1] > 0 && !isRobot[i+1]){
                    isRobot[i+1] = true;
                    belt[i+1]--;
                    isRobot[i] = false;
                }
            }

            for(int i = len-2; i>= N; i--){
                if(!isRobot[i]) continue;
                if(belt[i+1] > 0 && !isRobot[i+1]){
                    isRobot[i+1] = true;
                    belt[i+1]--;
                    isRobot[i] = false;
                }
            }

            if (isRobot[len-1] && belt[0] > 0 && !isRobot[0]) {
                isRobot[0] = true;
                belt[0]--;
                isRobot[len-1] = false;
            }

            //언제든지 로봇이 내리는 위치에 도달하면 그 즉시 내림
            isRobot[N-1] = false;

            //올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            if(belt[0] > 0 && !isRobot[0]){
                belt[0]--;
                isRobot[0] = true;
            }

            count = 0;
            for(int b : belt){
                if(b == 0) count++;
            }

        }
        System.out.println(level);
    }
}