import java.util.*;
import java.io.*;

class Main {
    //중앙값 : 어떤 주어진 값들을 크기의 순서대로 정렬했을 때 가장 중앙에 위치하는 값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int M = Integer.parseInt(br.readLine());
            sb.append(M/2+1).append("\n");
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = M / 10;
            int num = 0;
            while (cnt > 0) {
                cnt--;
                num++;
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= 10; j++) {
                    int n = Integer.parseInt(st.nextToken());
                    list.add(n);
                    if (j % 2 == 1) {
                        Collections.sort(list);
                        sb.append(list.get(list.size() / 2)).append(" ");
                    }
                }
                if (num%2 == 0) {
                    sb.append("\n");
                }
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M % 10; j++) {
                int n = Integer.parseInt(st.nextToken());
                list.add(n);
                if (j % 2 == 1) {
                    Collections.sort(list);
                    sb.append(list.get(list.size() / 2)).append(" ");
                }
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }
}