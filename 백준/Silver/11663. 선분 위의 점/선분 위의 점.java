import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()); //시작점
            int b = Integer.parseInt(st.nextToken()); //끝점

            // 배열에서 a이상인 첫 번째 위치 반환
            int startIdx = lowerBound(arr, a);
            // 배열에서 b이하인 첫 번째 위치 반환
            int endIdx = upperBound(arr, b);
            sb.append(endIdx - startIdx).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static int lowerBound(int[] arr, int a){
        int low = 0;
        int high = arr.length-1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] >= a){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    public static int upperBound(int[] arr, int b){
        int low = 0;
        int high = arr.length-1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] <= b){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return high+1;
    }
}