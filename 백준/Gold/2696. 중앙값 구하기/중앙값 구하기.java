import java.util.*;
import java.io.*;

class Main {
    //중앙값 : 어떤 주어진 값들을 크기의 순서대로 정렬했을 때 가장 중앙에 위치하는 값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (T-- > 0) {
            int M = Integer.parseInt(br.readLine());
            sb.append(M / 2 + 1).append("\n");
            ArrayList<Integer> list = new ArrayList<>();
            st = null;

            int cnt = 0;
            for (int i = 0; i < M; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }
                int n = Integer.parseInt(st.nextToken());
                list.add(n);
                if (i % 2 == 0) {
                    cnt++;
                    Collections.sort(list);
                    sb.append(list.get(list.size() / 2)).append(" ");
                    if (cnt % 10 == 0) {
                        sb.append("\n");
                    }
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}