import java.util.*;
import java.io.*;

class Main {
    static boolean[] visited;
    static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            boolean possible = false;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());
            visited = new boolean[10000];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{start, 0});

            while(!queue.isEmpty()){
                int[] current = queue.poll();
                int number = current[0];
                int count = current[1];

                if(number == target && isPrime(number)){
                    System.out.println(count);
                    possible = true;
                    break;
                }

                String strN = String.valueOf(number);

                for(int j = 0; j <= 9; j++){
                    int n0 = Integer.parseInt(j+strN.substring(1));
                    int n1 = Integer.parseInt(strN.substring(0,1) + j+strN.substring(2));
                    int n2 = Integer.parseInt(strN.substring(0,2)+j+strN.substring(3));
                    int n3 = Integer.parseInt(strN.substring(0,3)+j+strN.substring(4));
                    int[] arr = {n0, n1, n2, n3};
                    for(int a : arr){
                        if(!visited[a] && a >= 1000 && isPrime(a)){
                            visited[a] = true;
                            queue.add(new int[]{a, count+1});
                        }
                    }
                }
            }
            if(!possible){
                System.out.println("impossible");
            }
        }
    }

    public static boolean isPrime(int num){
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}