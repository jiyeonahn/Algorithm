import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않아야 함
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            int answer = N;
            int[][] applicant = new int[N][2];
            for(int j = 0; j < N; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                applicant[j][0] = Integer.parseInt(st.nextToken());//서류심사 성적 순위
                applicant[j][1] = Integer.parseInt(st.nextToken());//면접성적 순위
            }
            Arrays.sort(applicant, Comparator.comparingInt(a->a[0]));

            int min = applicant[0][1];
            for(int j = 1; j < N; j++){
                if(applicant[j][1] > min){
                    answer--;
                }
                min = Math.min(min, applicant[j][1]);
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}