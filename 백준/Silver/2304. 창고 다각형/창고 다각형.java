import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<int[]> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        int minL = 1000;
        int maxL = 0;
        int maxH = 0;
        int index = 0;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            map.put(L,H);
            if(H > maxH){
                maxH = H;
                index = L;
            }
            minL = Math.min(minL, L);
            maxL = Math.max(maxL, L);
        }

        int answer = maxH;

        int height = 0;
        for(int i = minL; i < index; i++){
            if(map.getOrDefault(i,0) > height){
                height = map.get(i);
            }
            answer += height;
        }

        height = 0;
        for(int i = maxL; i > index; i--){
            if(map.getOrDefault(i,0) > height){
                height = map.get(i);
            }
            answer += height;
        }

        System.out.println(answer);
    }
}