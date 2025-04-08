// 물고기 이동이 모두 끝나면 상어 이동
// 한 번에 여러 개의 칸을 이동할 수 있다.
// 이동하는 중에 지나가는 칸에 있는 물고기는 먹지 않는다.
// 물고기가 없는 칸으로는 이동할 수 없다.
// 상어가 이동할 수 있는 칸이 없으면 공간에서 벗어나 집으로 간다.

// 물고기는 번호가 작은 물고기부터 순서대로 이동한다.
// 한 칸 이동 가능, 빈 칸과 다른 물고기가 있는 칸
// 이동할 수 있는 칸을 향할 때까지 방향을 45도 반시계 회전시킴
// 모든 물고기가 이동

import java.util.*;
import java.io.*;

class Main {
    static int answer;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] num = new int[4][4];
        int[][] dir = new int[4][4];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
                dir[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        //1.상어가 (0,0)에 들어감
        int start = num[0][0];
        num[0][0] = 0;
        dfs(0, 0, start, dir[0][0], num, dir);//상어 X위치, 상어 Y위치, 상어 방향, sum

        System.out.println(answer);
    }

    public static void dfs(int x, int y, int sum, int sharkDir, int[][] num, int[][] dir) {
        answer = Math.max(answer, sum);

        int[][] tempNum = copyArray(num);
        int[][] tempDir = copyArray(dir);

        //2. 물고기 이동
        moveFish(x, y, tempNum, tempDir);

        //3. 상어 이동
        for (int i = 1; i < 4; i++) {
            int nx = x + dx[sharkDir] * i;
            int ny = y + dy[sharkDir] * i;
            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && tempNum[nx][ny] != 0) {// 물고기가 없는 칸으로는 이동할 수 없다.
                int[][] nexNum = copyArray(tempNum);
                int[][] nextDir = copyArray(tempDir);

                int nextFish = nexNum[nx][ny];     // 먹을 물고기 번호

                nexNum[nx][ny] = 0;                // 상어가 먹음 → 빈칸 처리

                dfs(nx, ny, sum + nextFish, nextDir[nx][ny], nexNum, nextDir);
            }
        }
    }

    public static int[][] copyArray(int[][] arr) {
        int[][] temp = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                temp[i][j] = arr[i][j];
            }
        }
        return temp;
    }

    public static void moveFish(int x, int y, int[][] num, int[][] dir) {
        int fishNum = 0;
        //2.물고기 이동
        while (fishNum <= 16) {
            fishNum++;
            int fx = -1;
            int fy = -1;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (num[i][j] == fishNum) {
                        fx = i;
                        fy = j;
                        break;
                    }
                }
            }

            //해당 번호의 물고기가 없음
            if(fx == -1 && fy == -1) continue;

            int idx = dir[fx][fy];
            for (int i = 0; i < 8; i++) {//만약, 이동할 수 있는 칸이 없으면 이동을 하지 않는다.
                //물고기 방향으로 전진
                int nx = fx + dx[idx];
                int ny = fy + dy[idx];

                //이동할 수 있는 칸이라면
                if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && !(nx == x && ny == y)) {

                    //그 칸에 있는 물고기와 위치 바꾸기
                    int temp = num[fx][fy];

                    num[fx][fy] = num[nx][ny];
                    num[nx][ny] = temp;

                    dir[fx][fy] = dir[nx][ny];
                    dir[nx][ny] = idx;
                    break;
                }
                //이동할 수 있는 칸을 향할 때까지 방향을 45도 반시계 회전시킨다.
                idx = (idx + 1) % 8;

            }
        }
    }
}
