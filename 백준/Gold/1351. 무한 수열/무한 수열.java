import java.util.*;
import java.io.*;
class Main{
    static long N,P,Q;
    static HashMap<Long, Long> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        map = new HashMap<>();
        map.put(0L, 1L);

        System.out.println(solve(N));
    }
    public static long solve(long n){
        if(map.containsKey(n)){
            return map.get(n);
        }
        long result = solve(n/P) + solve(n/Q);
        map.put(n, result);
        return result;
    }
}