import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<Character> set = new HashSet<>();


        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            String w = br.readLine();
            String[] words = w.split(" ");
            boolean hasKey = false;
            for (String word : words) {
                if (!set.contains(Character.toUpperCase(word.charAt(0))) && !hasKey) {
                    set.add(Character.toUpperCase(word.charAt(0)));
                    sb.append("[").append(word.charAt(0)).append("]").append(word.substring(1)).append(" ");
                    hasKey = true;
                    continue;
                }
                sb.append(word).append(" ");
            }
            if (!hasKey) {//모든 단어의 첫 글자가 이미 지정이 되어있다면
                sb.setLength(0);
                boolean findKey = false;
                for (int j = 0; j < w.length(); j++) {
                    if (w.charAt(j) != ' ' && !set.contains(Character.toUpperCase(w.charAt(j))) && !findKey) {
                        findKey = true;
                        set.add(Character.toUpperCase(w.charAt(j)));
                        sb.append("[").append(w.charAt(j)).append("]");
                    } else {
                        sb.append(w.charAt(j));
                    }
                }
            }
            System.out.println(sb);
        }

    }
}