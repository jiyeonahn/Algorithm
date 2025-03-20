import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] score = new double[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            score[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(score);

        double max = score[N-1];

        double sum = 0;

        for(double s : score){
            sum += s/max * 100;
        }

        System.out.println(sum/score.length);
    }
}