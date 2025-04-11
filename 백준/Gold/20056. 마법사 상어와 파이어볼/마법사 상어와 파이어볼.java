import java.util.*;
import java.io.*;

class Main {
    static ArrayList<Node>[][] temp;
    static int N;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Node>[][] fireball = new ArrayList[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fireball[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            fireball[r][c].add(new Node(m, s, d));
        }

        for (int t = 0; t < K; t++) {
            temp = new ArrayList[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    temp[i][j] = new ArrayList<>();
                }
            }

            //모든 파이어볼이 자신의 방향 di로 속력 si칸 만큼 이동한다
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (Node node : fireball[i][j]) {
                        moveFireball(i, j, node.m, node.s, node.d);
                    }
                }
            }

            fireball = temp;

            //이동이 모두 끝난 뒤, 2개 이상의 파이어볼
            temp = new ArrayList[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    temp[i][j] = new ArrayList<>();
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (fireball[i][j].size() >= 2) {
                        int mSum = 0;
                        int sSum = 0;
                        int evenD = 0;
                        int oddD = 0;
                        int cnt = fireball[i][j].size();

                        for (Node node : fireball[i][j]) {
                            mSum += node.m;
                            sSum += node.s;
                            if (node.d % 2 == 0) {
                                evenD++;
                            } else {
                                oddD++;
                            }
                        }

                        int[] newD = {};
                        if (evenD == cnt || oddD == cnt) {
                            newD = new int[]{0, 2, 4, 6};
                        } else {
                            newD = new int[]{1, 3, 5, 7};
                        }

                        int newM = (int) Math.floor(mSum / 5);
                        int newS = (int) Math.floor(sSum / cnt);

                        if (newM > 0) {
                            for (int k = 0; k < 4; k++) {
                                temp[i][j].add(
                                        new Node(newM, newS, newD[k]));
                            }
                        }
                    }
                    if (fireball[i][j].size() == 1) {
                        temp[i][j].add(
                                new Node(fireball[i][j].get(0).m, fireball[i][j].get(0).s, fireball[i][j].get(0).d));
                    }
                }
            }
            fireball = temp;
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (Node node : fireball[i][j]) {
                    sum += node.m;
                }
            }
        }

        System.out.println(sum);
    }

    public static void moveFireball(int x, int y, int m, int s, int d) {
        int nx = (x + dx[d] * s) % N;
        int ny = (y + dy[d] * s) % N;

        if (nx < 0) {
            nx = N + nx;
        }
        if (ny < 0) {
            ny = N + ny;
        }
        temp[nx][ny].add(new Node(m, s, d));
    }
}

class Node {
    int m;
    int s;
    int d;

    public Node(int m, int s, int d) {
        this.m = m;
        this.s = s;
        this.d = d;
    }
}