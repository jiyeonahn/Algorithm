import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        String[] dna = str.split("");
        int[] acgt = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            acgt[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int start = 0;
        int end = start + P - 1;
        String[] ch = {"A", "C", "G", "T"};
        int[] count = new int[4];

        for (int i = start; i < end; i++) {
            for (int j = 0; j < 4; j++) {
                if (dna[i].equals(ch[j])) {
                    count[j]++;
                }
            }
        }
        while (end < S) {
            //슬라이딩 윈도우: 오른쪽으로 한칸 이동 후 이동 후 개수를 늘려줌
            for (int i = 0; i < 4; i++) {
                if (dna[end].equals(ch[i])) {
                    count[i]++;
                }
            }

            //최소개수 이상이라면
            if (acgt[0] <= count[0] && acgt[1] <= count[1] && acgt[2] <= count[2] && acgt[3] <= count[3]) {
                answer++;
            }
            //슬라이딩 윈도우: 오른쪽으로 한칸 이동 후 이동 전 개수는 다시 줄여줌
            for (int i = 0; i < 4; i++) {
                if (dna[start].equals(ch[i])) {
                    count[i]--;
                }
            }
            start++;
            end++;
        }
        System.out.println(answer);
    }
}