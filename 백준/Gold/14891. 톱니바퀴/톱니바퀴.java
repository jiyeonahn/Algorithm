import java.util.*;
import java.io.*;

class Main {
    static int[][] wheel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wheel = new int[4][8];

        for (int i = 0; i < 4; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheel[i][j] = str.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1; // 회전시킨 톱니바퀴 번호
            int B = Integer.parseInt(st.nextToken()); // 방향, 1: 시계방향, -1: 반시계 방향

            int left = wheel[A][6];
            int right = wheel[A][2];

            //현재 바퀴 돌리기
            moveWheel(A, B);
            int dir = B;
            for (int j = A - 1; j >= 0; j--) {
                if (left == wheel[j][2]) {
                    break;
                }
                left = wheel[j][6];
                dir *= -1;
                moveWheel(j, dir);

            }

            dir = B;
            for (int j = A + 1; j < 4; j++) {
                if (right == wheel[j][6]) {
                    break;
                }
                right = wheel[j][2];
                dir *= -1;
                moveWheel(j, dir);
            }

        }

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (wheel[i][0] == 1) {
                answer += (int) Math.pow(2, i);
            }
        }

        System.out.println(answer);
    }

    public static void moveWheel(int n, int dir) {
        if (dir == 1) {//시계 방향
            int temp = wheel[n][7];
            for (int i = 7; i > 0; i--) {
                wheel[n][i] = wheel[n][i - 1];
            }
            wheel[n][0] = temp;
        } else {//반시계 방향
            int temp = wheel[n][0];
            for (int i = 0; i < 7; i++) {
                wheel[n][i] = wheel[n][i + 1];
            }
            wheel[n][7] = temp;
        }
    }
}