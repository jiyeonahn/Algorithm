import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj16198 { //에너지 모으기
    private static int N, answer;
    private static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int sum) {
        if(list.size() < 3){
            answer = Math.max(sum, answer);
            return;
        }

        for (int i = 1; i < list.size() - 1; i++) {
            int temp = list.get(i);
            int weight = list.get(i-1) * list.get(i+1);
            list.remove(i);
            dfs(sum + weight);
            list.add(i,temp);
        }
    }
}