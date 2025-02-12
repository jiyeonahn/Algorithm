import java.util.*;
import java.io.*;

class Main {
    static int[][] beer;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());//기간
        M = Integer.parseInt(st.nextToken());//선호도 합
        int K = Integer.parseInt(st.nextToken());//맥주 종류

        beer = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            beer[i][0] = Integer.parseInt(st.nextToken());//선호도
            beer[i][1] = Integer.parseInt(st.nextToken());//도수레벨
        }

        Arrays.sort(beer, Comparator.comparingInt(a -> a[1])); //1) 도수 기준으로 오름차순

        PriorityQueue<Integer> pq = new PriorityQueue<>(); //2) 선호도 기준으로 오름차순
        int sum = 0; //선호도 합
        int answer = -1;
        for (int[] a : beer) {
            int like = a[0];
            int alcohol = a[1];

            pq.add(like);
            sum += like;

            if (pq.size() > N) {
                sum -= pq.poll();
            }
            if (pq.size() == N) {
                if (sum >= M) { //선호도 합이 M이상 되어야 함
                    answer = alcohol;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}