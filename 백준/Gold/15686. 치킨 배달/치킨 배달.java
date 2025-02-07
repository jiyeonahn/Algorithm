import java.util.*;
import java.io.*;

class Main {
    static boolean[][] chickenIsValid;
    static List<int[]> selected = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static List<int[]> home = new ArrayList<>();
    static int M;
    static int N;
    static int answer = Integer.MAX_VALUE;

    public static void selectChickens(int startIndex, int count) {
        if (count == M) {
            answer = Math.min(calculateDistance(selected), answer);
            return;
        }
        for (int i = startIndex; i < chickens.size(); i++) {
            int[] chicken = chickens.get(i);
            selected.add(new int[]{chicken[0], chicken[1]});
            selectChickens(i + 1, count + 1);
            selected.remove(selected.size() - 1);
        }

    }

    private static int calculateDistance(List<int[]> selectedChickens) {
        int sum = 0;

        for (int[] h : home) {
            int min = Integer.MAX_VALUE; // 집마다 최솟값 갱신
            for (int[] c : selectedChickens) {
                min = Math.min(Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]), min); // 3) 집에서 가장 가까운 치킨 집 찾기
            }
            sum += min;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        chickenIsValid = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 1) {
                    home.add(new int[]{i, j});
                }
                if (n == 2) {
                    chickens.add(new int[]{i, j});
                }

            }
        }

        // 1) M개의 치킨집 선별하기
        selectChickens(0, 0);

        System.out.println(answer);
    }
}