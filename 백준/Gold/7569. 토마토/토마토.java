import java.util.*;
import java.io.*;

class Main {
    static int day;
    static int N, M, H;
    static int[][][] tomato;
    static boolean[][][] visited;
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomato = new int[H][N][M];
        visited = new boolean[H][N][M];

        boolean completed = true;
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    tomato[k][i][j] = Integer.parseInt(st.nextToken());
                    if(tomato[k][i][j] == 0){
                        completed = false;
                    }
                }
            }
        }

        if(completed){//모든 토마토가 익어있는 상황
            System.out.println(0);
            return;
        }

        //1:익은 토마토, 0:익지 않은 토마토, -1:x
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[k][i][j] && tomato[k][i][j] == 1) {
                        visited[k][i][j] = true;
                        queue.add(new Node(k, i, j, 0)); //익은 토마토들을 집어넣음
                    }
                }
            }
        }
        bfs();
        boolean raw = false;
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (tomato[k][i][j] == 0) {//토마토가 모두 익지 못하는 상황
                        raw = true;
                        break;
                    }
                }
            }
        }
        System.out.println(raw ? -1 : day);
    }

    public static void bfs() {
        int[] dn = {0, 1, 0, -1, 0, 0};
        int[] dm = {1, 0, -1, 0, 0, 0};
        int[] dh = {0, 0, 0, 0, 1, -1};
        day = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int h = node.h;
            int n = node.n;
            int m = node.m;
            day = node.day;

            for (int i = 0; i < 6; i++) {
                int dn_n = n + dn[i];
                int dm_m = m + dm[i];
                int dh_h = h + dh[i];

                if (dn_n >= 0 && dn_n < N && dm_m >= 0 && dm_m < M && dh_h >= 0 && dh_h < H) {
                    if (!visited[dh_h][dn_n][dm_m] && tomato[dh_h][dn_n][dm_m] == 0) {
                        visited[dh_h][dn_n][dm_m] = true;
                        tomato[dh_h][dn_n][dm_m] = 1;
                        queue.add(new Node(dh_h, dn_n, dm_m, day + 1));
                    }
                }
            }
        }
    }
}

class Node {
    int h;
    int n;
    int m;
    int day;

    public Node(int h, int n, int m, int day) {
        this.h = h;
        this.n = n;
        this.m = m;
        this.day = day;
    }
}