import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            if (N % 100 == 0) {
                sb.append("Bye");
            } else {
                if ((N + 1) % (N % 100) == 0) {
                    sb.append("Good");
                } else {
                    sb.append("Bye");
                }
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }
}