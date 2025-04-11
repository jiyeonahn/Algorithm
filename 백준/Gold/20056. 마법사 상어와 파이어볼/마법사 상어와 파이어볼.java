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

        // 1) 한 칸에 여러 개의 파이어볼이 들어갈 수 있으므로 ArrayList<Node>[][]로 선언해주었다.
        ArrayList<Node>[][] fireball = new ArrayList[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fireball[i][j] = new ArrayList<>();
            }
        }

        // 2) 입력받은 파이어볼을 배열 리스트에 질량, 속도, 방향의 정보를 넣는다.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            fireball[r][c].add(new Node(m, s, d));
        }

        // 3) 새로운 격자를 만들어 이동 후 파이어볼의 위치를 담는다.
        for (int t = 0; t < K; t++) {
            temp = new ArrayList[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    temp[i][j] = new ArrayList<>();
                }
            }

            // 4) 모든 파이어볼이 자신의 방향 d로 속력 s칸 만큼 이동한다
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (Node node : fireball[i][j]) {
                        moveFireball(i, j, node.m, node.s, node.d);
                    }
                }
            }

            //5) 얕은복사(참조복사)를 하여 fireball은 이제 temp의 내용을 가리킨다
            fireball = temp;

            // 6) 이동이 모두 끝난 뒤, 2개 이상의 파이어볼 나누기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int size = fireball[i][j].size();
                    if (size >= 2) {
                        int mSum = 0;
                        int sSum = 0;
                        int evenD = 0;
                        int oddD = 0;

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
                        if (evenD == size || oddD == size) {
                            newD = new int[]{0, 2, 4, 6};
                        } else {
                            newD = new int[]{1, 3, 5, 7};
                        }

                        int newM = (int) Math.floor(mSum / 5);
                        int newS = (int) Math.floor(sSum / size);

                        // 7) 현재 칸 초기화
                        fireball[i][j] = new ArrayList<>();

                        // 8) 현재 칸에 분할 된 4개의 파이어볼 추가
                        if (newM > 0) {
                            for (int k = 0; k < 4; k++) {
                                fireball[i][j].add(
                                        new Node(newM, newS, newD[k]));
                            }
                        }
                    }
                }
            }
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