import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int pointer = 0;
        int answer = 0;

        do {
            answer++;
            String str = String.valueOf(answer);
            for (int i = 0; i < str.length(); i++) {
                if (pointer == N.length()) {
                    break;
                }
                if (str.charAt(i) == N.charAt(pointer)) {
                    pointer++;
                }
            }

        } while (pointer != N.length());

        System.out.println(answer);
    }
}