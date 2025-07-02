import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());//빌딩의 수
        int[] buildings = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            int answer = 0;
            double left = Integer.MAX_VALUE;
            double right = Integer.MIN_VALUE;

            for (int j = i - 1; j >= 0; j--) {
                double slope = (double) (buildings[i] - buildings[j]) / (i - j);
                if (slope < left) {
                    left = slope;
                    answer++;
                }
            }

            for (int j = i + 1; j < N; j++) {
                double slope = (double) (buildings[i] - buildings[j]) / (i - j); //0.xx가 0이 되는듯!!!

                if (slope > right) {
                    right = slope;
                    answer++;
                }
            }
            max = Math.max(max, answer);
        }
        System.out.println(max);
    }
}