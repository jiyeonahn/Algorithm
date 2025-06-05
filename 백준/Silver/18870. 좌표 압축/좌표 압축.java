import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sortArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
            sortArr[i] = n;
        }
        //xi보다 작은 수는 몇개인가?
        Arrays.sort(sortArr);
        int seq = -1;
        int prev = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            if(sortArr[i]>prev){
                seq++;
            }
            map.put(sortArr[i],seq);
            prev = sortArr[i];
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            sb.append(map.get(arr[i])).append(" ");
        }

        System.out.println(sb);
    }
}