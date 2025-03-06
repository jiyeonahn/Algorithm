import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        HashSet<Integer> set = new HashSet<>();

        int[] ingredient = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            ingredient[i] = Integer.parseInt(st.nextToken());
            set.add(ingredient[i]);
        }

        int answer = 0;

        for(int i = 0; i < N; i++){
            int target = M - ingredient[i];
            set.remove(ingredient[i]);
            if(set.remove(target)){
                answer++;
            }
        }
        System.out.println(answer);
    }
}