import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int INF = Integer.MAX_VALUE;
        int answer = INF;
        int N = Integer.parseInt(st.nextToken());

        String now = br.readLine();
        String targetStr = br.readLine();
        char[] target = targetStr.toCharArray();

        int count1 = 0; // 첫번째 전구를 끈 상태로 시작
        int count2 = 1; // 첫번째 전구를 켠 상태로 시작

        String light1 = now;

        char[] chars = now.toCharArray();
        chars[0] = chars[0] == '1' ? '0' : '1';
        chars[1] = chars[1] == '1' ? '0' : '1';
        String light2 = new String(chars);

        char[] chars1 = light1.toCharArray();
        char[] chars2 = light2.toCharArray();

        for (int i = 1; i < N; i++) {
            if (chars1[i - 1] != target[i - 1]) {
                chars1[i - 1] = chars1[i - 1] == '1' ? '0' : '1';
                chars1[i] = chars1[i] == '1' ? '0' : '1';

                if (i < N - 1) {
                    chars1[i + 1] = chars1[i + 1] == '1' ? '0' : '1';
                }

                count1++;
            }

            if (chars2[i - 1] != target[i - 1]) {
                chars2[i - 1] = chars2[i - 1] == '1' ? '0' : '1';
                chars2[i] = chars2[i] == '1' ? '0' : '1';

                if (i < N - 1) {
                    chars2[i + 1] = chars2[i + 1] == '1' ? '0' : '1';
                }

                count2++;
            }
        }

        light1 = new String(chars1);
        light2 = new String(chars2);

        if (light1.equals(targetStr)) {
            answer = count1;
        }

        if (light2.equals(targetStr)) {
            answer = Math.min(answer, count2);
        }

        System.out.println(answer == INF ? -1 : answer);
    }
}