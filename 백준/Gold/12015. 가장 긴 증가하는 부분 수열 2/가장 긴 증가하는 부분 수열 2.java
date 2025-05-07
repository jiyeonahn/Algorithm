import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {//가장 긴 증가하는 부분 수열2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] seq = new int[N+1];
        for(int i = 0; i < N; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            if(list.get(list.size()-1) < seq[i]){
                list.add(seq[i]);
            }
            else{
                int left = 0;
                int right = list.size()-1;
                while(left < right){
                    int mid = (left + right) / 2;
                    if(list.get(mid) < seq[i]){
                        left = mid + 1;
                    }else {
                        right = mid;
                    }
                }
                list.set(right, seq[i]);
            }

        }
        System.out.println(list.size()-1);
    }
}
