import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringBuilder sb = new StringBuilder();
            Deque<Integer> dequeue = new LinkedList<>();
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            str = str.substring(1, str.length() - 1);
            StringTokenizer st = new StringTokenizer(str, ",");

            for (int j = 0; j < n; j++) {
                dequeue.add(Integer.parseInt(st.nextToken()));
            }

            boolean isReserved = false;
            boolean isError = false;
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == 'R') {
                    isReserved = !isReserved;
                } else { //D일때
                    if (dequeue.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReserved) {
                        dequeue.pollLast();
                    } else {
                        dequeue.pollFirst();
                    }
                }
            }

            if (isError) {
                answer.append("error\n");
            } else {
                answer.append("[");
                while (!dequeue.isEmpty()) {
                    answer.append(isReserved ? dequeue.pollLast() : dequeue.pollFirst());
                    if (!dequeue.isEmpty()) {
                        answer.append(",");
                    }
                }
                answer.append("]\n");
            }
        }
        System.out.println(answer);
    }
}