import java.util.*;
import java.io.*;

class Main {
    static int N;
    static char[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        star = new char[N][N * 2 - 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N * 2 - 1; j++) {
                star[i][j] = ' ';
            }
        }

        triangle(0, N - 1, N);

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N * 2 - 1; j++) {
                answer.append(star[i][j]);
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }

    public static void triangle(int i, int j, int n) {
        if (n == 3) {
            star[i][j] = '*';
            star[i + 1][j - 1] = star[i + 1][j + 1] = '*';
            star[i + 2][j - 2] = star[i + 2][j - 1] = star[i + 2][j] = star[i + 2][j + 1] = star[i + 2][j + 2] = '*';
        } else {
            triangle(i, j, n / 2);
            triangle(i + n/2, j - n/2, n/2);
            triangle(i + n/2, j + n/2, n/2);
        }

    }
}