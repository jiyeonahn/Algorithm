import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();

        String[] answer = new String[N];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            answer[i] = "";
            boolean isKey = false;
            for (String s : str) {
                if (!set.contains((s.charAt(0) + "").toUpperCase()) && !isKey) {
                    set.add((s.charAt(0) + "").toUpperCase());
                    answer[i] += "[" + s.charAt(0) + "]" + s.substring(1) + " ";
                    isKey = true;
                    continue;
                }
                answer[i] += s + " ";
            }
            if (!isKey) {//모든 단어의 첫 글자가 이미 지정이 되어있다면
                int len = answer[i].length();
                String str2 = answer[i];
                answer[i] = "";
                boolean find = false;
                for (int j = 0; j < len; j++) {
                    if(str2.charAt(j) == ' ') {
                        answer[i] += str2.charAt(j);
                        continue;
                    }
                    if (!set.contains((str2.charAt(j) + "").toUpperCase()) && !find) {
                        find = true;
                        set.add((str2.charAt(j) + "").toUpperCase());
                        answer[i] += "[" + str2.charAt(j) + "]";
                    } else {
                        answer[i] += str2.charAt(j);
                    }
                }
            }
        }
        for (String ss : answer) {
            System.out.println(ss);
        }
    }
}