import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 카운팅 정렬 : 데이터의 크기와 범위가 제한적일 때 효율적
        int[] count = new int[10001];
        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(br.readLine());
            count[n]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < 10001; i++){
            while(count[i] > 0){
                sb.append(i).append("\n");
                count[i]--;
            }
        }
        System.out.println(sb.toString());
    }
}