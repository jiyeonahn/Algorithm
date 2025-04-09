//1. 좋아하는 학생이랑 가장 많이 붙을 수 있는 칸
//2. 비어있는 칸이랑 가장 많이 붙을 수 있는 칸
//3. 행의 번호가 가장 작은 칸
//4. 열의 번호가 가장 작은 칸

import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] seat;
    static ArrayList<Integer>[] list;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        list = new ArrayList[N * N + 1];

        for (int i = 0; i <= N * N; i++) {
            list[i] = new ArrayList<>();
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            int like1 = Integer.parseInt(st.nextToken());
            int like2 = Integer.parseInt(st.nextToken());
            int like3 = Integer.parseInt(st.nextToken());
            int like4 = Integer.parseInt(st.nextToken());
            queue.add(student);
            list[student].add(like1);
            list[student].add(like2);
            list[student].add(like3);
            list[student].add(like4);
        }

        seat = new int[N][N];
        //첫번째 학생은 무조건 (1,1)
        seat[1][1] = queue.poll();

        while (!queue.isEmpty()) {
            //자리를 정할 학생
            int s = queue.poll();
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                //행,열,좋아하는사람,빈칸
                if (a[2] != b[2]) {
                    return b[2] - a[2];// 좋아하는 학생이 인접한 칸에 가장 많은 칸으로
                }
                if (a[3] != b[3]) {
                    return b[3] - a[3];// 비어있는 칸이 가장 많은 칸으로
                }
                if (a[0] != b[0]) {
                    return a[0] - b[0];// 행의 번호가 가장 작은 칸으로
                }
                return a[1] - b[1];// 열의 번호가 가장 작은 칸으로
            });

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (seat[i][j] != 0) {
                        continue; //비어있는 칸만 검사
                    }
                    int[] result = findSeat(s, i, j);
                    pq.add(new int[]{i, j, result[0], result[1]});
                }
            }

            int[] sit = pq.poll();
            seat[sit[0]][sit[1]] = s;
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += satisfied(seat[i][j], i,j);
            }
        }

        System.out.println(sum);
    }

    public static int[] findSeat(int s, int x, int y) {
        int likeStudent = 0;
        int emptySeat = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (list[s].contains(seat[nx][ny])) {
                    likeStudent++;
                }
                if (seat[nx][ny] == 0) {
                    emptySeat++;
                }
            }
        }
        return new int[]{likeStudent, emptySeat};
    }

    public static int satisfied(int s, int x, int y){
        int likeStudent = 0;
        int[] score = {0,1,10,100,1000};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (list[s].contains(seat[nx][ny])) {
                    likeStudent++;
                }
            }
        }
        return score[likeStudent];
    }
}